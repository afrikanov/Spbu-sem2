package group144.afrikanov;

import static java.lang.Integer.parseInt;

public class Operand extends Node {

    Operand(String value) {
        this.value = value;
    }

    /*** Method prints a value in a node */
    @Override
    public void print() {
        System.out.print(value);
    }

    /**
     * @return a value in a node
     * @throws InvalidTreeException if the tree is invalid
     */
    @Override
    public int calculate() throws InvalidTreeException {
        if (isNumber(value)) {
            return parseInt(value);
        } else {
            throw new InvalidTreeException();
        }
    }

    /**
     * Method checks if the string can be converted in number. Returns true if can, false otherwise.
     * @param isNumberValue - string that tries to be converted to number
     */
    private boolean isNumber(String isNumberValue) {
        try  {
            Integer.parseInt(isNumberValue);
            return true;
        }
        catch (NumberFormatException exception) {
            return false;
        }
    }
}
