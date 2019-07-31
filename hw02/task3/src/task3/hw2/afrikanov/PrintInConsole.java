package task3.hw2.afrikanov;

import java.io.IOException;
import java.io.PrintStream;

public class PrintInConsole implements Outputer {

    /**
     * Method prints a matrix to console
     * @param a - certain matrix
     */
    @Override
    public void printArray(int[][] a) throws IOException {
        PrintSpiral.resultOutput(a, new PrintStream(System.out));
    }
}
