package sorters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Reads a CSV file of numbers and inputs them into arrays of a specified size
 * Created by zachrooney on 3/6/17.
 */
public class SimulateChunks {

    private final int memorySize = 100;
    private String fileName;
    ArrayList<Integer[]> arrayChunks;

    /**
     * Generic constructor
     */
    public SimulateChunks() {

    }

    /**
     * Reads a CSV file of numbers and inputs them into arrays (as Integer objects) of a specified size. It stores the arrays in ArrayList<Integer[]>.
     * If there are any numbers remaning at the end of the file it will make a smaller array to account for them and add them to the ArrayList
     *
     * @param memSize
     * @param filePath
     * @param fileChunksAsArrays
     */

    public static void splitFileIntoArrayChunks(int memSize, String filePath, ArrayList<Integer[]> fileChunksAsArrays) {

        //ArrayList <Integer> tempArrayList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                Integer[] tempInts = new Integer[memSize];
                for (int i = 0; i < memSize; i++) {
                    //tempInts[i] = Integer.parseInt(scanner.next());
                    // while (scanner.hasNext()){
                    tempInts[i] = Integer.parseInt(scanner.next());
                    if (!scanner.hasNext()) {                                //possible error, move 1 line up?
                        break;
                    }
                }
                boolean nullCheck = true;
                for (Integer e : tempInts)
                    if (e == null) {
                        nullCheck = false;
                    }
                if (nullCheck) {
                    fileChunksAsArrays.add(tempInts);
                } else {
                    int count = 0;
                    for (int j = 0; j < tempInts.length; j++) {
                        if (tempInts[j] != null) {
                            count++;
                        }
                    }
                    Integer[] shortChunk = new Integer[count];
                    for (int k = 0; k < count; k++) {
                        shortChunk[k] = tempInts[k];
                    }


                    fileChunksAsArrays.add(shortChunk);
                }

                //tempArrayList.add(tempInts);

            }
            // System.out.println(fileChunksAsArrays.toString());                for Debugging
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File Not Found");
        }

    }
}
