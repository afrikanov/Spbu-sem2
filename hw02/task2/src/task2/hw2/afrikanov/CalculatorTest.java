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
        assertEquals(25, actual);
    }

    @Test
    void countMiddleTest() throws FullStackException, EmptyStackException {
        String actualString = "50 5 2 3 + * /";
        Calculator getAnswer = new Calculator();
        int actual = getAnswer.count(actualString);
        assertEquals(2, actual);
    }

    @Test
    void countBigTest() throws FullStackException, EmptyStackException {
        String actualString = "7 50 5 2 3 + * / -";
        Calculator getAnswer = new Calculator();
        int actual = getAnswer.count(actualString);
        assertEquals(5, actual);
    }
}