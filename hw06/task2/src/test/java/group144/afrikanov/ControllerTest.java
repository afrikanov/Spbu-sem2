package group144.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void isVictoryTest() {
        Character[][] table = new Character[][]{
                {'X', 'O', ' '},
                {'X', 'O', ' '},
                {'X', ' ', ' '}};
        assertEquals(Character.valueOf('X'), Controller.isVictory(table));
        table = new Character[][]{
                {'X', 'X', 'X'},
                {'O', 'O', ' '},
                {' ', ' ', ' '}};
        assertEquals(Character.valueOf('X'), Controller.isVictory(table));
        table = new Character[][]{
                {'O', ' ', 'X'},
                {'O', 'X', ' '},
                {'X', ' ', ' '}};
        assertEquals(Character.valueOf('X'), Controller.isVictory(table));
        table = new Character[][]{
                {'X', ' ', 'O'},
                {'O', 'X', ' '},
                {' ', ' ', 'X'}};
        assertEquals(Character.valueOf('X'), Controller.isVictory(table));
        table = new Character[][]{
                {'O', ' ', ' '},
                {' ', 'X', ' '},
                {' ', ' ', ' '}};
        assertEquals(Character.valueOf(' '), Controller.isVictory(table));
        table = new Character[][]{
                {'O', 'X', 'X'},
                {'X', 'X', 'O'},
                {'O', 'O', 'X'}};
        assertEquals(Character.valueOf('D'), Controller.isVictory(table));
    }
}