package group144.afrikanov;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class realizes the hash-table using LinkedList
 */
class HashTable {

    private ArrayList<LinkedList<String>> table;
    private HashFunction hashFunction;
    private final int SIZE = (int)1e5 + 7;

    HashTable(HashFunction hash) {
        hashFunction = hash;
        table = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; ++i) {
            table.add(new LinkedList<>());
        }
    }

    /**
     * Method adds a hash of a certain string to the table
     * @param value - value needed to add
     */
    public void add(String value) {
        int position = hashFunction.hash(value, SIZE);
        table.get(position).add(value);
    }

    /**
     * Method deletes a hash of a certain string from the table
     * @param value - value needed to delete
     * @throws ValueNotFoundException if the value is not found
     */
    public void delete(String value) throws ValueNotFoundException {
        int position = hashFunction.hash(value, SIZE);
        for (var element : table.get(position)) {
            if (element.equals(value)) {
                table.get(position).remove(element);
                return;
            }
        }
        throw new ValueNotFoundException("Value not found");
    }

    /**
     * Method that checks your value in a list
     * @param value - value should be checked that it is contained
     */
    public boolean contains(String value) {
        return table.get(hashFunction.hash(value, table.size())).contains(value);
    }

    /** @return amount of elements in hash table */
    public int getElementsAmount() {
        int answer = 0;
        for (LinkedList<String> element : table) {
            answer += element.size();
        }
        return answer;
    }

    /** @return amount of conflicts in hash table */
    public int getConflictsAmount() {
        int answer = 0;
        for (LinkedList<String> element : table) {
            if (element.size() >= 2) {
                answer += element.size() - 1;
            }
        }
        return answer;
    }

    public double loadFactor() {
        return (double)getElementsAmount() / table.size();
    }

    /** @return answer - maximum of amounts of elements of the table with the same hashes */
    public int getMaxListSize() {
        int answer = 0;
        for (LinkedList<String> element : table) {
            answer = Math.max(answer, element.size());
        }
        return answer;
    }

    /** Method, which prints hash table parameters */
    void printStatistics() {
        System.out.println("Load factor : " + loadFactor());
        System.out.println("Amount of values : " + getElementsAmount());
        System.out.println("Amount of possible hashes : " + SIZE);
        System.out.println("Amount of collisions : " + getConflictsAmount());
        System.out.println("The biggest amount of strings with equal hashes : " + getMaxListSize());
    }
}
