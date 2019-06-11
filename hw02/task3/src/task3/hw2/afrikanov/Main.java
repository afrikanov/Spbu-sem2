package task3.hw2.afrikanov;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of matrix");
        int n = input.nextInt();
        int[][] a = new int[n][n];
        System.out.println("Enter Matrix");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = input.nextInt();
            }
        }
        System.out.println("Write 1 if you want to write the matrix in console");
        System.out.println("Write 2 if you want to write the matrix in file");
        int select = input.nextInt();
        if (select == 1) {
            Outputer out = new PrintInConsole();
            out.printArray(a);
        }
        else if (select == 2) {
            Outputer out = new PrintInFile();
            out.printArray(a);
        }
        input.close();
    }
}