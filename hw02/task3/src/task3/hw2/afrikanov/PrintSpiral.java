package task3.hw2.afrikanov;

import java.io.IOException;

public class PrintSpiral {

    /**
     * Method makes a string from a matrix in a spiral
     * @param a - certain matrix
     * @return a string if numbers in a current order
     */
    public static void resultOutput(int[][] a, Outputer printer) throws IOException {
        int posI = a.length / 2;
        int posJ = a[0].length / 2;
        printer.printElement(a[posI][posJ] + " ");
        ++posJ;
        int k = 2;
        while (posI < a.length && posJ < a.length) {
            int i = posI, j = posJ;
            for (i = posI; i > posI - k; --i) {
                printer.printElement(a[i][j] + " ");
            }
            i++;
            j--;
            posI = i;
            posJ = j;
            for (j = posJ; j > posJ - k; --j) {
                printer.printElement(a[i][j] + " ");
            }
            j++;
            i++;
            posJ = j;
            posI = i;
            for (i = posI; i < posI + k; ++i) {
                printer.printElement(a[i][j] + " ");
            }
            i--;
            j++;
            posJ = j;
            posI = i;
            for (j = posJ; j < posJ + k; ++j) {
                printer.printElement(a[i][j] + " ");
            }
            posJ = j;
            ++j;
            k += 2;
        }
    }
}
