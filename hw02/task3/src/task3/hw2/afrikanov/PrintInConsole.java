package task3.hw2.afrikanov;

public class PrintInConsole<T> implements Outputer<T> {

    /**
     * Method prints a matrix to console
     * @param a - certain matrix
     */
    @Override
    public void print(T[][] a) {
        PrintSpiral printer = new PrintSpiral();
        System.out.print(printer.resultOutput(a));
    }
}
