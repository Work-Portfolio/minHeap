package sorters;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Class creates a designated amount of random numbers and writes them to an output file. Used for testing SortFileData
 * Created by zachrooney on 3/16/17.
 */
public class RandomNumberGenerator {

    public static void main(String[] args) {

        final int howMany = 10000;
            // The target file
            File out = new File("resources/numbers05.txt");
            FileWriter fw;
            int n = howMany;
            // Try block: Most stream operations may throw IO exception
            try {
                // Create file writer object
                fw = new FileWriter(out);
                // Wrap the writer with buffered streams
                BufferedWriter writer = new BufferedWriter(fw);
                int line;
                Random random = new Random();
                while (n > 0) {
                    // Randomize an integer and write it to the output file
                    line = random.nextInt(10000);
                    writer.write(line + ",");
                    n--;
                }
                // Close the stream
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
