package sorters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is designed to test the output file from SortFileData to ensure all data is inorder
 * Created by zachrooney on 3/16/17.
 */
public class TestOutput {
    // final String filePath = "resources/result_using_min_heap_20170316_065126.txt";


    public static void main(String[] args) {
        final String filePath = "resources/result_using_min_heap_20170316_081051.txt";


        try {
            Scanner scanner = new Scanner(new File(filePath));
            scanner.useDelimiter(",");
            int prevInt = Integer.parseInt(scanner.next());
            while (scanner.hasNext()) {
                int currentInt = Integer.parseInt(scanner.next());
                // System.out.println("Comparing: " + prevInt + " : " + currentInt);
                if (prevInt > currentInt) {
                    System.out.println("***********************************************************************");
                    System.out.println("OUT OF ORDER: " + prevInt + " : " + currentInt);
                    System.out.println("***********************************************************************");

                }
                if (!scanner.hasNext()) {
                    break;
                }
                prevInt = currentInt;

            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File Not Found");
        }
        System.out.println("DONE WITH CHECK");
    }
}