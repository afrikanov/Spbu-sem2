package task3.hw2.afrikanov;

import java.io.IOException;

/** Interface for printing the matrix in different output streams */
public interface Outputer  {
    /**
     * Method prints a matrix in a spiral format
     * @param a - certain matrix
     * @throws IOException when attempt to write in a file failed
     */
    void print(int[][] a) throws IOException;
}
