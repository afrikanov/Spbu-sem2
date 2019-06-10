package task3.hw2.afrikanov;

import java.io.PrintStream;

public class PrintSpiral {

    /**
     * Method makes a string from a matrix in a spiral
     * @param a - certain matrix
     * @return a string if numbers in a current order
     */
    public static String resultOutput(int[][] a) {
        int posI = a.length / 2;
        int posJ = a[0].length / 2;
        StringBuilder current = new StringBuilder();
        current.append(a[posI][posJ]).append(" ");
        ++posJ;
        int k = 2;
        while (posI < a.length && posJ < a.length) {
            int i = posI, j = posJ;
            for (i = posI; i > posI - k; --i) {
                current.append(a[i][j]).append(" ");
            }
            i++;
            j--;
            posI = i;
            posJ = j;
            for (j = posJ; j > posJ - k; --j) {
                current.append(a[i][j]).append(" ");
            }
            j++;
            i++;
            posJ = j;
            posI = i;
            for (i = posI; i < posI + k; ++i) {
                current.append(a[i][j]).append(" ");
            }
            i--;
            j++;
            posJ = j;
            posI = i;
            for (j = posJ; j < posJ + k; ++j) {
                current.append(a[i][j]).append(" ");
            }
            posJ = j;
            ++j;
            k += 2;
        }
        return current.toString();
    }
}
