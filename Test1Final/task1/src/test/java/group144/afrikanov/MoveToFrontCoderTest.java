package group144.afrikanov;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MoveToFrontCoderTest {

    @Test
    public void exampleCodeTest() {
        MoveToFrontCoder coder = new MoveToFrontCoder();
        String word = "banana";
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 1, 13, 1, 1, 1));
        assertEquals(expected, coder.code(word));
    }

    @Test
    public void exampleEncodeTest() {
        MoveToFrontCoder encoder = new MoveToFrontCoder();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 13, 1, 1, 1));
        String expected = "banana";
        assertEquals(expected, encoder.encode(list));
    }

    @Test
    public void codeTest() {
        MoveToFrontCoder coder = new MoveToFrontCoder();
        String word = "aaabbc";
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 2));
        assertEquals(expected, coder.code(word));
    }

    @Test
    public void encodeTest() {
        MoveToFrontCoder encoder = new MoveToFrontCoder();
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 2));
        String expected = "aaabbc";
        assertEquals(expected, encoder.encode(list));
    }
}