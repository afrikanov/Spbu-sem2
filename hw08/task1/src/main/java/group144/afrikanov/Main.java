package group144.afrikanov;

import java.util.Random;

public class Main {

    private final static int SIZE = (int)1e6;
    private final static int TESTS_AMOUNT = 40;
    private static int[] arrayOneThread = new int[SIZE];
    private static int[] arrayMultiThread = new int[SIZE];
    private static long oneThreadSummaryTime = 0;
    private static long multiThreadSummaryTime = 0;
    private static Random random = new Random();

    public static void main(String[] args) {
        oneThreadSummaryTime = 0;
        multiThreadSummaryTime = 0;
        for (int i = 0; i < TESTS_AMOUNT; ++i) {
            fillArray(arrayOneThread);
            arrayMultiThread = arrayOneThread.clone();
            Sort oneThreadSorter = new OneThreadQSort();
            oneThreadSummaryTime += executionTime(arrayOneThread, oneThreadSorter);
            Sort multiThreadSorter = new MultiThreadQSort();
            multiThreadSummaryTime += executionTime(arrayMultiThread, multiThreadSorter);
        }
        System.out.println("One Thread Sorting lasted : " + (double)oneThreadSummaryTime / TESTS_AMOUNT);
        System.out.println("Multi Thread Sorting lasted : " + (double)multiThreadSummaryTime / TESTS_AMOUNT);
    }

    /** Method fills an array with random integers */
    private static void fillArray(int[] randomizedArray) {
        for (int i = 0; i < SIZE; ++i) {
            randomizedArray[i] = random.nextInt();
        }
    }

    /** Method returns a time of execution of a sorting function */
    private static long executionTime(int[] sortableArray, Sort sorter) {
        long initialTime = System.currentTimeMillis();
        sorter.sort(sortableArray, 0, sortableArray.length - 1);
        return System.currentTimeMillis() - initialTime;
    }
}