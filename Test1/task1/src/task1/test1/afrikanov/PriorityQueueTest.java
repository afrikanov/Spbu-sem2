package task1.test1.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test
    void enqueueTest() {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(2, 3);
        queue.enqueue(3, 4);
        queue.enqueue(4, 5);
        assertEquals(3, queue.getSize());
    }

    @Test
    void dequeTest() throws EmptyQueueException {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(10, 10);
        queue.enqueue(20, 20);
        queue.dequeue();
        assertEquals(1, queue.getSize());
    }

    @Test
    void queueMaxPriorityTest() throws EmptyQueueException {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(10, 10);
        queue.enqueue(20, 20);
        queue.enqueue(30, 30);
        assertEquals(30, queue.dequeue());
    }

    @Test
    void exceptionTest() throws EmptyQueueException {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(11, 11);
        queue.enqueue(22, 22);
        assertEquals(22, queue.dequeue());
        assertEquals(11, queue.dequeue());
        try {
            queue.dequeue();
        }
        catch (EmptyQueueException exception) {
            assertTrue(true);
        }
    }
}