Zach Rooney
CS 1C

rooneyz-project08


Brief description of submitted files:

src/cs1c/FHbinHeap.java
    - This file is an example of a minHeap given to use by the professor. It is never used but code for MinHeap was modeled after it

src/cs1c/FHsort.java
    - This class holds a lot of sorting methods. It is used by BasicSorter class

src/cs1c/TimeConverter.java
    - One object of class TimeConverter converts a duration of time in seconds and converts to a string representation with
      hour, min, sec.

src/sorters/BasicSorter
    - This class is designed to sort the Integer [] chunks into acending order.
    - For smaller chunks it uses insertion sort
    - Anything Interger[] over size 30 will be sorted by quickSort

src/sorters/HeapTuple
    - This is a wrapper class used by MinHeap
    - It stores the data as well as which chunk and chunk index it came from

src/sorters/Minheap
    - This is the class that holds and manages the minheap

src/sorters/MinheapArrayMerger
    - This class contains the method that creates the MinHeap and uses it to sort through the Integer[] chunks. It writes
      all the values to a specified output file in ascending order.

src/sorters/RandomNumberGenerator
    - This class was written to create a large CSV .txt file of random numbers
    - It's output file is used to test SortFileData

src/sorters/SimulateChunks
    - This class reads a .txt CSV file of numbers and fills Integer[] objects (of a specified size) with them.

src/sorters/SortFileData
    - Contains the 'main'
    - This class was given to us by the professor.
    - It simulates using a minheap to sort a lot of data. It simulates having memory size restrictions

src/sorters/TestOutput
    - This class was written to test the output files of SortDataFiles.
    - It reads the output file and indicates if any of the numbers are not in ascending order

resources/RUN.txt
    - A copy of the console output from this program. There are multiple runs for different conditions and resource files
      used.

