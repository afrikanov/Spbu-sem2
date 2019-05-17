package group144.afrikanov;

import java.util.*;

import static java.util.Collections.swap;

/** Class realizes a move-to-front coding algorithm. */
public class MoveToFrontCoder {

    private List<Character> alphabet = new ArrayList<>();

    /** Method initializes alphabet */
    private void initialize() {
        for (Character letter = 'a'; letter <= 'z'; ++letter) {
            alphabet.add(letter);
        }
        for (Character letter = 'A'; letter <= 'Z'; ++letter) {
            alphabet.add(letter);
        }
    }

    /**
     * A method that realizes a move-to-front iteration. It updates a position of the letter and move it to front
     * @param position - a current position of the letter which will be moved to front
     */
    private void moveToFront(int position) {
        List<Character> newAlphabet = new ArrayList<>(alphabet);
        while (position > 0) {
            swap(newAlphabet, position - 1, position);
            position--;
        }
        alphabet = newAlphabet;
    }

    /**
     * A method that codes a word using move-to-front algorithm.
     * @param word - a word that should be coded
     * @return - a list with a coded
     */
    public List<Integer> code(String word) {
        initialize();
        List<Integer> result = new ArrayList<>();
        for (Character letter : word.toCharArray()) {
            int currentPosition = alphabet.indexOf(letter);
            result.add(currentPosition);
            moveToFront(currentPosition);
        }
        return result;
    }

    /**
     *  Method encodes a list of integers
     * @param inputList - list that should be encoded
     * @return an encoded string
     */
    public String encode(List<Integer> inputList) {
        initialize();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputList.size(); i++) {
            Character currentChar = alphabet.get(inputList.get(i));
            result.append(currentChar);
            moveToFront(inputList.get(i));
        }
        return result.toString();
    }
}
