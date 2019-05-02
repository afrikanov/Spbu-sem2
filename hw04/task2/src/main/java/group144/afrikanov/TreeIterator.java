package group144.afrikanov;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class realizes the AVL Tree iterator of a type
 *
 * @param <T> Type you want to use in your AVL Tree
 */
public class TreeIterator <T extends Comparable<T>> implements Iterator<T> {
    private AVLTree<T>.Node<T> next;

    TreeIterator(AVLTree<T>.Node<T> node) {
        next = node;
        if (next == null) {
            return;
        }
        while (next.getLeftNode() != null) {
            next = next.getLeftNode();
        }
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        AVLTree<T>.Node<T> currentNode = next;
        if (next.getRightNode() != null) {
            next = next.getRightNode();
            while (next.getLeftNode() != null) {
                next = next.getLeftNode();
            }
            return currentNode.getKey();
        } else {
            while (true) {
                if (next.getParent() == null) {
                    next = null;
                    return currentNode.getKey();
                } else {
                    if (next.getParent().getLeftNode() == next) {
                        next = next.getParent();
                        return currentNode.getKey();
                    } else {
                        next = next.getParent();
                    }
                }
            }
        }
    }
}
