package task3.hw2.afrikanov;

import java.io.FileWriter;
import java.io.IOException;

public class PrintInFile implements Outputer {

    @Override
    public void print(int[][] A) {
        int PosI = A.length / 2;
        int PosJ = A[0].length / 2;
        try(FileWriter Writer = new FileWriter("File.txt")) {
            Writer.write(A[PosI][PosJ] + " ");
            ++PosJ;
            int k = 2;
            while (PosI < A.length && PosJ < A.length) {
                int i = PosI, j = PosJ;
                for (i = PosI; i > PosI - k; --i) {
                    Writer.write(A[i][j] + " ");
                }
                i++;
                --j;
                PosI = i;
                PosJ = j;
                for (j = PosJ; j > PosJ - k; --j) {
                    Writer.write(A[i][j] + " ");
                }
                j++;
                ++i;
                PosJ = j;
                PosI = i;
                for (i = PosI; i < PosI + k; ++i) {
                    Writer.write(A[i][j] + " ");
                }
                i--;
                ++j;
                PosJ = j;
                PosI = i;
                for (j = PosJ; j < PosJ + k; ++j) {
                    Writer.write(A[i][j] + " ");
                }
                PosJ = j;
                ++j;
                k += 2;
            }
            Writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
