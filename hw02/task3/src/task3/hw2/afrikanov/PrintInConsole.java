package task3.hw2.afrikanov;

import java.io.PrintStream;

public class PrintInConsole extends PrintSpiral implements Outputer {

    /**
     * Method prints a matrix to console
     * @param a - certain matrix
     */
    @Override
    public void print(int[][] a) {
        PrintStream consoleWriter = new PrintStream(System.out);
        consoleWriter.print(resultOutput(a));
    }
}
