package task3.hw2.afrikanov;

import org.junit.jupiter.api.Test;

import javax.lang.model.type.IntersectionType;
import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class OutputerTest {

    @Test
    public void printOneElementInColsole() throws IOException {
        ByteArrayOutputStream actual = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actual));
        int[][] arrayStart = {{10}};
        Outputer output = new PrintInConsole();
        output.print(arrayStart);
        String expecteds = "10 ";
        assertEquals(expecteds, actual.toString());
    }

    @Test
    public void printInConsole() throws IOException {
        ByteArrayOutputStream actual = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actual));
        int[][] arrayStart = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Outputer output = new PrintInConsole();
        output.print(arrayStart);
        String expecteds = "5 6 3 2 1 4 7 8 9 ";
        assertEquals(expecteds, actual.toString());
    }

    @Test
    public void printInFile() throws IOException {
        int[][] arrayStart = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        Outputer output = new PrintInFile();
        output.print(arrayStart);
        Scanner file = new Scanner(new File("File.txt"));
        String expecteds = "3 4 4 3 2 2 2 3 4 5 5 5 5 4 3 2 1 1 1 1 1 2 3 4 5 ";
        assertEquals(expecteds, file.nextLine());
    }
}