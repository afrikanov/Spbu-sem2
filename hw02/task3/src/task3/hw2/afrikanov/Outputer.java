package task3.hw2.afrikanov;

import java.io.IOException;

/** Interface for printing the matrix in different output streams */
public interface Outputer  {

    /**
     * Method prints an array in a spiral format
     * @param a - certain matrix
     * @throws IOException when attempt to write in a file failed
     */
    void printArray(int[][] a) throws IOException;

    /**
     * Prints one element
     * @param currentElement - a certain string
     * @throws IOException when attempt to write in a file failed
     */
    void printElement(String currentElement) throws IOException;
}
