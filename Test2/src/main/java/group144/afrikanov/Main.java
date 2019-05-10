package group144.afrikanov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<LinkedList<String>> allArrays = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Print 'exit' to stop");
        while(true) {
            String inputLine = in.nextLine();
            if (inputLine.equals("exit")) {
                break;
            }
            LinkedList<String> stepList = new LinkedList<>();
            StringBuilder elementNow = new StringBuilder();
            for (int j = 0; j < inputLine.length(); ++j) {
                if (inputLine.charAt(j) == ' ' && elementNow.length() == 0) {
                    continue;
                } else if (inputLine.charAt(j) == ' ' && elementNow.length() > 0) {
                    stepList.add(elementNow.toString());
                    elementNow = new StringBuilder();
                } else {
                    elementNow.append(inputLine.charAt(j));
                }
            }
            if (elementNow.length() > 0) {
                stepList.add(elementNow.toString());
            }
            allArrays.add(stepList);
        }
        SortedSet sortedSet = new SortedSet(allArrays);
        sortedSet.print();
    }
}
