package sorters;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  Takes an ArrayList<Integer[]> then sorts them using a minheap and writes them in ascending order to an output file "s".
 * Created by zachrooney on 3/6/17.
 */
public class MinHeapArrayMerger {

    /**
     * Generic constructor
     */
    public MinHeapArrayMerger() {

    }

    /**
     * Takes an ArrayList<Integer[]> then sorts them using a minheap and writes them in ascending order to an output file "s". It restricts the size
     * of the minheap used to the size of the HeapTuple[] parameter.
     * @param fileChunksAsArrays
     * @param emptyHeap
     * @param s
     * @param enableDebugPhase02
     */
    public static void mergeSortedArrays(ArrayList<Integer[]> fileChunksAsArrays, HeapTuple[] emptyHeap, String s, boolean enableDebugPhase02) {

        int[] indexCount = new int[fileChunksAsArrays.size()];
        for (int e : indexCount) {
            e = 0;
        }
        MinHeap minHeap = new MinHeap(emptyHeap);
        boolean moreValues = true;
        BufferedWriter bw;

        try {
            bw = new BufferedWriter(new FileWriter(s));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR: MinHeapArrayMerger mergeSortedArrays() Problem creating output file: " + s);
            return;
        }

        // int debugCount = 0;       For Debug

        while (moreValues) {
            moreValues = false;
            for (int i = 0; i < fileChunksAsArrays.size(); i++) {
                // debugCount++;

                Integer[] tempChunk = fileChunksAsArrays.get(i);
                if (indexCount[i] >= tempChunk.length) {
                    continue;
                }
                if (!minHeap.isFull()) {
                    HeapTuple newTuple = new HeapTuple(tempChunk[indexCount[i]], i, indexCount[i]);
                    minHeap.insert(newTuple);
                    moreValues = true;
                    indexCount[i]++;
                    continue;
                }
                if (tempChunk[indexCount[i]] < minHeap.getLast()) {
                    HeapTuple toReturn;
                    toReturn = minHeap.remove();
//                    Integer [] returnChunk = fileChunksAsArrays.get(toReturn.getArrayIndex());    //Just need to move indexCount
//                    returnChunk[toReturn.getIndexInArray()] = toReturn.getData();
                    indexCount[toReturn.getArrayIndex()]--;
                    HeapTuple newTuple = new HeapTuple(tempChunk[indexCount[i]], i, indexCount[i]);
                    minHeap.insert(newTuple);
                    moreValues = true;
                    indexCount[i]++;
                }

            }
            HeapTuple root = minHeap.removeRoot();
            String dataToWrite = root.getData() + ",";
            try {
                bw.write(dataToWrite);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("ERROR: MinHeapArrayMerger mergeSortedArrays() Problem writing to output file: " + s);
            }

        }

        while (!minHeap.isEmpty()) {
            HeapTuple root = minHeap.removeRoot();
            String dataToWrite = root.getData() + ",";
            try {
                bw.write(dataToWrite);
                //System.out.println ("*******Writting:  " + dataToWrite.toString());      // For Debugging
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("ERROR: MinHeapArrayMerger mergeSortedArrays() Problem writing to output file: " + s);
            }
            //System.out.println("Heap Size: " +minHeap.size());    // For Debugging
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
