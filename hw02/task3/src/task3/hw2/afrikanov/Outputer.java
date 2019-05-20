package task3.hw2.afrikanov;

import java.io.IOException;

/** Interface for printing the matrix in different output streams */
public interface Outputer<T> {

    /**
     * Method prints a matrix in a spiral format
     * @param a - certain matrix
     * @throws IOException when attempt to write in a file failed
     */
    void print(T[][] a) throws IOException;
}
