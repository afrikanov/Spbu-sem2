package group144.afrikanov;

public class Operand implements Node {

    private int value;

    public Operand(int value) {
        this.value = value;
    }

    public Operand(String inputString) {
        if (inputString.charAt(inputString.length() - 1) >= '0' &&
                inputString.charAt(inputString.length() - 1) <= '9') {
            value = Integer.parseInt(inputString);
        } else {
            value = Integer.parseInt(inputString.substring(0, inputString.indexOf(')')));
        }
    }

    /** A method that calculates value of the node */
    @Override
    public int calculate() {
        return value;
    }

    /** A method that prints the node */
    @Override
    public void print() {
        System.out.print(value);
    }
}
