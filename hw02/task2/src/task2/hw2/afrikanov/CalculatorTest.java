package task2.hw2.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void countSmallTest() throws FullStackException, EmptyStackException {
        int current = 25;
        String actualString = "5 2 3 + *";
        Calculator getAnswer = new Calculator();
        int actual = getAnswer.count(actualString);
        assertEquals(actual, current);
    }

    @Test
    void countMiddleTest() throws FullStackException, EmptyStackException {
        int current = 2;
        String actualString = "50 5 2 3 + * /";
        Calculator getAnswer = new Calculator();
        int actual = getAnswer.count(actualString);
        assertEquals(actual, current);
    }

    @Test
    void countBigTest() throws FullStackException, EmptyStackException {
        int current = 5;
        String actualString = "7 50 5 2 3 + * / -";
        Calculator getAnswer = new Calculator();
        int actual = getAnswer.count(actualString);
        assertEquals(actual, current);
    }
}