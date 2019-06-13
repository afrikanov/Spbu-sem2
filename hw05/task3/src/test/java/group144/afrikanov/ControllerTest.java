package group144.afrikanov;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void expressionSumTest() throws DivisionByZeroException, SqrtFromNegativeDigit {
        ArrayList<String> expression = new ArrayList<>();
        expression.add("5");
        expression.add("+");
        expression.add("5");
        expression.add("+");
        ArrayList<String> expressionByStep = new ArrayList<>();
        String answer = "";
        for (int i = 0; i < expression.size(); ++i) {
            expressionByStep.add(expression.get(i));
            answer = Controller.handleExpression(expressionByStep);
        }
        assertEquals("10.0", answer);
    }

    @Test
    void expressionMultiplyTest() throws DivisionByZeroException, SqrtFromNegativeDigit {
        ArrayList<String> expression = new ArrayList<>();
        expression.add("5");
        expression.add("*");
        expression.add("5");
        expression.add("/");
        ArrayList<String> expressionByStep = new ArrayList<>();
        String answer = "";
        for (int i = 0; i < expression.size(); ++i) {
            expressionByStep.add(expression.get(i));
            answer = Controller.handleExpression(expressionByStep);
        }
        assertEquals("25.0", answer);
    }

    @Test
    void expressionDivisionTest() throws DivisionByZeroException, SqrtFromNegativeDigit {
        ArrayList<String> expression = new ArrayList<>();
        expression.add("4");
        expression.add("/");
        expression.add("2");
        expression.add("=");
        ArrayList<String> expressionByStep = new ArrayList<>();
        String answer = "";
        for (int i = 0; i < expression.size(); ++i) {
            expressionByStep.add(expression.get(i));
            answer = Controller.handleExpression(expressionByStep);
        }
        assertEquals("2.0", answer);
    }

    @Test
    void expressionMinusTest() throws DivisionByZeroException, SqrtFromNegativeDigit {
        ArrayList<String> expression = new ArrayList<>();
        expression.add("5");
        expression.add("-");
        expression.add("6");
        expression.add("+");
        ArrayList<String> expressionByStep = new ArrayList<>();
        String answer = "";
        for (int i = 0; i < expression.size(); ++i) {
            expressionByStep.add(expression.get(i));
            answer = Controller.handleExpression(expressionByStep);
        }
        assertEquals("-1.0", answer);
    }

    @Test
    void expressionCombinedTest() throws DivisionByZeroException, SqrtFromNegativeDigit {
        ArrayList<String> expression = new ArrayList<>();
        expression.add("9");
        expression.add("+");
        expression.add("5");
        expression.add("/");
        expression.add("+");
        expression.add("/");
        expression.add("2");
        expression.add("-");
        expression.add("0");
        expression.add("=");
        expression.add("+-");
        expression.add("-");
        expression.add("5");
        expression.add("0");
        expression.add("=");
        expression.add("deleteLast");
        ArrayList<String> expressionByStep = new ArrayList<>();
        String answer = "";
        for (int i = 0; i < expression.size(); ++i) {
            expressionByStep.add(expression.get(i));
            answer = Controller.handleExpression(expressionByStep);
        }
        assertEquals("-5.0", answer);
    }

    @Test
    void expressionExceptionsTest() throws DivisionByZeroException, SqrtFromNegativeDigit {
        ArrayList<String> expression = new ArrayList<>();
        expression.add("5");
        expression.add("/");
        expression.add("0");
        expression.add("=");
        ArrayList<String> expressionByStep = new ArrayList<>();
        String answer = "";
        for (int i = 0; i < expression.size() - 1; ++i) {
            expressionByStep.add(expression.get(i));
            answer = Controller.handleExpression(expressionByStep);
        }
        expressionByStep.add(expression.get(expression.size() - 1));
        assertThrows(DivisionByZeroException.class, () -> Controller.handleExpression(expressionByStep));
        expression.add("C");
        expression.add("4");
        expression.add("+-");
        expression.add("sqrt");
        for (int i = 4; i < expression.size() - 1; ++i) {
            expressionByStep.add(expression.get(i));
            answer = Controller.handleExpression(expressionByStep);
        }
        expressionByStep.add(expression.get(expression.size() - 1));
        assertThrows(SqrtFromNegativeDigit.class, () -> Controller.handleExpression(expressionByStep));
    }
}