package group144.afrikanov;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class realizes the hash-table using LinkedList
 */
class HashTable {

    private ArrayList<LinkedList<String>> table;
    private HashFunction hashFunction;
    private int elementsAmount = 0, conflictsAmount = 0;

    HashTable(HashFunction hash, int size) {
        hashFunction = hash;
        table = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            table.add(new LinkedList<>());
        }
    }

    /**
     * Method adds a hash of a certain string to the table
     * @param value - value needed to add
     */
    void add(String value) {
        int item = hashFunction.hash(value, table.size());
        if (table.get(item).size() == 1) {
            conflictsAmount++;
        }
        table.get(item).add(value);
        elementsAmount++;
    }

    /**
     * Method deletes a hash of a certain string from the table
     * @param value - value needed to delete
     * @throws ValueNotFoundException if the value is not found
     */
    void delete(String value) throws ValueNotFoundException {
        int item = hashFunction.hash(value, table.size());
        if (table.get(item).remove(value)) {
            if (table.get(item).size() == 1) {
                conflictsAmount--;
            }
            elementsAmount--;
        } else {
            throw new ValueNotFoundException("Value not found.");
        }
    }

    /**
     * Method that checks your value in a list
     * @param value - value should be checked that it is contained
     */
    boolean contains(String value) {
        return table.get(hashFunction.hash(value, table.size())).contains(value);
    }

    int getElementsAmount() {
        return elementsAmount;
    }

    int getConflictsAmount() {
        return conflictsAmount;
    }

    double loadFactor() {
        return (double) getElementsAmount() / table.size();
    }

    /**
     * @return answer - maximum of amounts of elements of the table with the same hashes
     */
    int getMaxListSize() {
        int answer = 0;
        for (int i = 0; i < table.size(); ++i) {
            answer = Math.max(answer, table.get(i).size());
        }
        return answer;
    }
}
