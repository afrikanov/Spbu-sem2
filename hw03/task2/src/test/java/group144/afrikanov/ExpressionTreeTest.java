package group144.afrikanov;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTreeTest {

    @Test
    void calculateExample() {
        Scanner in = new Scanner("(* (+ 1 1) 2)");
        ExpressionTree tree = new ExpressionTree(in);
        assertEquals(4, tree.calculate());
    }

    @Test
    void calculateTwoOperands() {
        Scanner in = new Scanner("(/ 8 4)");
        ExpressionTree tree = new ExpressionTree(in);
        assertEquals(2, tree.calculate());
    }

    @Test
    void calculateTwoOperators() {
        Scanner in = new Scanner("(* (+ 2 3) (/ 9 3))");
        ExpressionTree tree = new ExpressionTree(in);
        assertEquals(15, tree.calculate());
    }

    @Test
    void calculateNode() {
        Node operand1 = new Operand("7");
        Node operand2 = new Operand(6);
        Node operator = new Operator('*', operand1, operand2);
        ExpressionTree tree = new ExpressionTree(operator);
        assertEquals(42, tree.calculate());
    }
}