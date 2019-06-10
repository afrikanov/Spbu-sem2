package group144.afrikanov;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ValueNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose a Hash Function. \n 1 - Polynomial. \n 2 - Multiply. \n 3 - Xor. \n Any other - Polynomial");
        HashFunction currentHash;
        int hashNumber = in.nextInt();
        currentHash = selectHash(hashNumber);
        HashTable hashTable = new HashTable(currentHash);
        System.out.println("New Hash-table created. \n Choose a number of command to continue.");
        System.out.println("1 number (Create a new hash table and select a hash function. 1 - polynomial, 2 - multiply, 3 - xor, any other - polynomial)");
        System.out.println("2 word (Add a new word to table)");
        System.out.println("3 word (Delete a new word to table)");
        System.out.println("4 (Print statistics)");
        System.out.println("5 word (Return true if word contains and false in other way)");
        System.out.println("6 input.txt (Fill from input.txt)");
        System.out.println("7 (Exit)");
        int command = 0;
        while (command != 7) {
            command = in.nextInt();
            switch (command) {
                case 1 :
                    currentHash = selectHash(in.nextInt());
                    hashTable = new HashTable(currentHash);
                case 2 :
                    hashTable.add(in.next());
                    break;
                case 3 :
                    hashTable.delete(in.next());
                    break;
                case 4 :
                    hashTable.printStatistics();
                    break;
                case 5 :
                    System.out.println(hashTable.contains(in.next()));
                    break;
                case 6 :
                    fillFromFile(hashTable, in.next());
                    break;
            }
        }
    }

    private static HashFunction selectHash(int hashNumber) {
        switch (hashNumber) {
            case 1 :
                return new PolynomialHashFunction();
            case 2 :
                return new MultiplyHashFunction();
            case 3 :
                return new XorHashFunction();
            default:
                return new PolynomialHashFunction();
        }
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
}
