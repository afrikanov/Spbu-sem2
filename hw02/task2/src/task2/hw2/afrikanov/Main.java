package task2.hw2.afrikanov;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack stack = new StackList();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an expression. Example : 5 2 3 + *");
        String inputString = input.nextLine();
        input.close();
        Calculator calculate = new Calculator();
        System.out.println(calculate.count(inputString));
    }
}