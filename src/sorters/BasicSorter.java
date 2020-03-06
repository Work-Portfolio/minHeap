package sorters;

import cs1c.FHsort;

/**
 *  This class takes an Integer[] as a parameter then sorts it. If Integer[]<30, insertion sort is used, if >30 than quickSort is used
 * Created by zachrooney on 3/6/17.
 */
public class BasicSorter {


    /**
     *Generic Constructor
     */
    public BasicSorter (){
    }

    /**
     * Sorts an Integer[] into ascending order
     * @param chunk
     */
    public static void sortChunk(Integer[] chunk) {
//       for (Integer e : chunk) {
//           System.out.println(e.toString());  //For Debugging
//       }
       if (chunk == null){
           return;
            }
        if (chunk.length < 30)
        {
            int temp;
            for (int i = 1; i < chunk.length; i++) {
                for(int j = i ; j > 0 ; j--){
                    if(chunk[j] < chunk[j-1])
                    {
                        temp = chunk[j];
                        chunk[j] = chunk[j-1];
                        chunk[j-1] = temp;
                    }
                }
            }
        }
        if (chunk.length >= 30){
            FHsort.quickSort(chunk);
        }
    }
}
