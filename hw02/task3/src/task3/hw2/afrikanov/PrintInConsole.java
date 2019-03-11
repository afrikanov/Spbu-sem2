package task3.hw2.afrikanov;

public class PrintInConsole implements Outputer {

    @Override
    public void print(int[][] a) {
        int posI = a.length / 2;
        int posJ = a[0].length / 2;
        System.out.print(a[posI][posJ] + " ");
        ++posJ;
        int k = 2;
        while (posI < a.length && posJ < a.length) {
            int i = posI, j = posJ;
            for (i = posI; i > posI - k; --i) {
                System.out.print(a[i][j] + " ");
            }
            i++;
            j--;
            posI = i;
            posJ = j;
            //System.out.println("i j = " + i + " " + j);
            for (j = posJ; j > posJ - k; --j) {
                System.out.print(a[i][j] + " ");
            }
            j++;
            i++;
            posJ = j;
            posI = i;
            //System.out.println("i j = " + i + " " + j);
            for (i = posI; i < posI + k; ++i) {
                System.out.print(a[i][j] + " ");
            }
            i--;
            j++;
            posJ = j;
            posI = i;
            //System.out.println("i j = " + i + " " + j);
            for (j = posJ; j < posJ + k; ++j) {
                System.out.print(a[i][j] + " ");
            }
            posJ = j;
            ++j;
            k += 2;
            //System.out.println("i j = " + i + " " + j);
        }
    }
}
