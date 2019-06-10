package task3.hw2.afrikanov;

import java.io.PrintStream;

public class PrintInConsole implements Outputer {

    /**
     * Method prints a matrix to console
     * @param a - certain matrix
     */
    @Override
    public void print(int[][] a) {
        PrintStream consoleWriter = new PrintStream(System.out);
        PrintSpiral.resultOutput(a, consoleWriter);
    }
}
