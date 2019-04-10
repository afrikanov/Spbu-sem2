package group144.afrikanov;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ValueNotFoundException {
        Scanner in = new Scanner(System.in);
        final int SIZE = (int)1e5 + 7;
        System.out.println("Choose a Hash Function. \n 1 - Polynomial. \n 2 - Multiply. \n 3 - Xor.");
        HashFunction currentHash = new PolynomialHashFunction();
        int hashNumber = in.nextInt();
        switch (hashNumber) {
            case 1 :
                currentHash = new PolynomialHashFunction();
                break;
            case 2 :
                currentHash = new MultiplyHashFunction();
                break;
            case 3 :
                currentHash = new XorHashFunction();
                break;
        }
        HashTable hashTable = new HashTable(currentHash, SIZE);
        printMenu();
        int command = 0;
        while (command != 6) {
            command = in.nextInt();
            switch (command) {
                case 1 :
                    hashTable.add(in.next());
                    break;
                case 2 :
                    hashTable.delete(in.next());
                    break;
                case 3 :
                    printStatistics(hashTable);
                    break;
                case 4 :
                    System.out.println(hashTable.contains(in.next()));
                    break;
                case 5 :
                    fillFromFile(hashTable, in.next());
                    break;
            }
        }
    }

    /**
     * Method, which prints user's abilities
     */
    private static void printMenu() {
        System.out.println("New Hash-table created. \n Choose a number of command to continue.");
        System.out.println("1 word (Add a new word to table)");
        System.out.println("2 word (Delete a new word to table)");
        System.out.println("3 (Print statistics)");
        System.out.println("4 word (Return true if word contains and false in other way)");
        System.out.println("5 input.txt (Fill from input.txt)");
        System.out.println("6 (Exit)");
    }

    /**
     * Method, which adds strings from file to the hash table
     * @param hashTable - hashtable, which should be filled
     * @param filename - the name of the certain file
     */
    private static void fillFromFile(HashTable hashTable, String filename) {
        Scanner file;
        System.out.println(filename);
        try {
            file = new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException exception) {
            System.out.println("File is not found.");
            return;
        }
        while (file.hasNext()) {
            hashTable.add(file.next());
        }
    }

    /**
     * Method, which prints hash table parameters
     * @param hashTable - hashtable, which will be printed
     */
    private static void printStatistics(HashTable hashTable) {
        System.out.print("General Elements Amount: ");
        System.out.println(hashTable.getElementsAmount());
        System.out.print("Conflicts Amount: ");
        System.out.println(hashTable.getConflictsAmount());
        System.out.print("Load factor: ");
        System.out.println(hashTable.loadFactor());
        System.out.print("Max list size: ");
        System.out.println(hashTable.getMaxListSize());
    }
}
