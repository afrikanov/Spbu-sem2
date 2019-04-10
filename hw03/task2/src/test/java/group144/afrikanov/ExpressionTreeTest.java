package group144.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTreeTest {

    @Test
    void calculateExample() throws InvalidTreeException {
        ExpressionTree tree = new ExpressionTree("(* (+ 1 1) 2)");
        assertEquals(4, tree.calculate());
    }

    @Test
    void calculateTwoOperands() throws InvalidTreeException {
        ExpressionTree tree = new ExpressionTree("(/ 8 4)");
        assertEquals(2, tree.calculate());
    }

    @Test
    void calculateTwoOperators() throws InvalidTreeException {
        ExpressionTree tree = new ExpressionTree("(* (+ 2 3) (/ 9 3))");
        assertEquals(15, tree.calculate());
    }

    @Test
    void currentInput() throws InvalidTreeException {
        try {
            ExpressionTree tree = new ExpressionTree("(/ ((* (+ 2 3) (/ 9 3)) 5)");
        } catch (InvalidTreeException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }
}