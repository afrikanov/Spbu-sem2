package group144.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void countPlusTest() {
        assertEquals("6", Controller.count(5, 1, '+'));
        assertEquals("13", Controller.count(5, 8, '+'));
    }

    @Test
    void countMinusTest() {
        assertEquals("4", Controller.count(5, 1, '-'));
        assertEquals("2", Controller.count(10, 8, '-'));
    }

    @Test
    void countMultyplyTest() {
        assertEquals("15", Controller.count(5, 3, '*'));
        assertEquals("10", Controller.count(5, 2, '*'));
    }

    @Test
    void countDivideTest() {
        assertEquals("1.25", Controller.count(5, 4, '/'));
        assertNull(Controller.count(5, 0, '/'));
    }
}