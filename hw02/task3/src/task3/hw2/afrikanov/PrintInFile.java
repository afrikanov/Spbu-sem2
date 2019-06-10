package task3.hw2.afrikanov;

import java.io.IOException;
import java.io.PrintStream;

public class PrintInFile implements Outputer {

    /**
     * Method prints a matrix to a file
     * @param a - certain matrix
     * @throws IOException when attempt to write in a file failed
     */
    @Override
    public void print(int[][] a) throws IOException {
        PrintStream fileWriter = new PrintStream("File.txt");
        PrintSpiral.resultOutput(a, fileWriter);
    }
}
