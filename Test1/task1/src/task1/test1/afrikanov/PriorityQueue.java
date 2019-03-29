package task1.test1.afrikanov;

import java.util.ArrayList;

/**
 * Class implements the data structure - priority queue
 * @param <T> - type of the value of the element of the priority queue
 */
public class PriorityQueue<T> {

    ArrayList<Node> queue = new ArrayList<>();

    /**
     * Method implements adding new element to the priority queue with certain value and priority
     * @param value
     * @param priority
     */
    public void enqueue(T value, int priority) {
        Node newNode = new Node(value, priority);
        queue.add(newNode);
    }

    /**
     * Method implements removing an element with the biggest priority from the queue
     * @return
     * @throws EmptyQueueException
     */
    public T dequeue() throws EmptyQueueException {
        if (queue.size() == 0) {
            throw new EmptyQueueException();
        }
        else {
            Node nodeWithBiggestPriority = queue.get(0);
            int position = 0;
            for (int i = 1; i < queue.size(); ++i) {
                if (queue.get(i).priority > nodeWithBiggestPriority.priority) {
                    position = i;
                    nodeWithBiggestPriority = queue.get(i);
                }
            }
            for (int i = position; i < queue.size() - 1; ++i) {
                queue.get(i).priority = queue.get(i + 1).priority;
                queue.get(i).value = queue.get(i + 1).value;
            }
            queue.remove(queue.size() - 1);
            return nodeWithBiggestPriority.value;
        }
    }

    public int getSize() {
        return queue.size();
    }

    /**
     * Class implements the structure of element of priority queue with 2 fields : value and priority
     */
    public class Node {

        T value;
        int priority;

        public Node(T value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }
}
