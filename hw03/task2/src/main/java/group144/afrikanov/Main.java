package group144.afrikanov;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidTreeException {
        Scanner in;
        String inputString = "";
        try {
            in = new Scanner(new FileInputStream("input.txt"));
            inputString = in.nextLine();
        }
        catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        ExpressionTree tree = new ExpressionTree(inputString);
        System.out.println("Your expression");
        tree.print();
        System.out.println();
        System.out.println("The result is : ");
        System.out.println(tree.calculate());
    }
}
