package task3.hw2.afrikanov;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintInFile extends PrintSpiral implements Outputer {

    private PrintStream fileWriter;

    public PrintInFile() throws FileNotFoundException {
        fileWriter = new PrintStream("File.txt");
    }

    /**
     * Method prints a matrix to a file
     * @param a - certain matrix
     * @throws IOException when attempt to write in a file failed
     */
    @Override
    public void printArray(int[][] a) throws IOException {
        PrintSpiral.resultOutput(a, this);
    }

    @Override
    public void printElement(String currentElement) {
        fileWriter.print(currentElement);
    }
}
