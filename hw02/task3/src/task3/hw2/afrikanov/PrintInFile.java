package task3.hw2.afrikanov;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintInFile implements Outputer {
    /**
     * Method prints a matrix to a file
     * @param a - certain matrix
     * @throws IOException when attempt to write in a file failed
     */
    @Override
    public void printArray(int[][] a) throws IOException {
        PrintSpiral.resultOutput(a, new PrintStream("out.txt"));
    }
}
