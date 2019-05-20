package task3.hw2.afrikanov;

import java.io.FileWriter;
import java.io.IOException;

public class PrintInFile<T> implements Outputer<T> {

    /**
     * Method prints a matrix to a file
     * @param a - certain matrix
     * @throws IOException when attempt to write in a file failed
     */
    @Override
    public void print(T[][] a) throws IOException {
        FileWriter writer = new FileWriter("File.txt");
        PrintSpiral printer = new PrintSpiral();
        writer.write(printer.resultOutput(a));
        writer.close();
    }
}
