package task3.hw2.afrikanov;

import java.io.IOException;

public class PrintInConsole implements Outputer {

    /**
     * Method prints a matrix to console
     * @param a - certain matrix
     */
    @Override
    public void printArray(int[][] a) throws IOException {
        PrintSpiral.resultOutput(a, this);
    }

    @Override
    public void printElement(String element) throws IOException {
        System.out.print(element);
    }
}
