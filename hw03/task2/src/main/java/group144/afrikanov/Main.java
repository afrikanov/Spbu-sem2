package group144.afrikanov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("input.txt"));
            ExpressionTree tree = new ExpressionTree(in);
            System.out.println("Your expression");
            tree.print();
            System.out.println();
            System.out.println("The result is : ");
            System.out.println(tree.calculate());
        }
        catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
    }
}
