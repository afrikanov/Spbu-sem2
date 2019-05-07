package group144.afrikanov;

import java.util.Iterator;

/**
 * Class realizes the AVL Tree iterator of a type
 * @param <T> Type you want to use in your AVL Tree
 */
public class TreeIterator <T extends Comparable<T>> implements Iterator<T> {
    private AVLTree<T>.Node<T> next;

    TreeIterator(AVLTree<T>.Node<T> node) {
        if (node == null) {
            return;
        }
        next = node;
        while (next.getLeftNode() != null) {
            next = next.getLeftNode();
        }
    }

    @Override
    public T next() throws NoNextElementException {
        AVLTree<T>.Node<T> currentNode = next;
        if (!hasNext()) {
            throw new NoNextElementException("No next element");
        }
        if (next.getRightNode() == null) {
            for ( ; ;) {
                if (next.getParent() != null) {
                    if (next.getParent().getLeftNode() == next) {
                        next = next.getParent();
                        return currentNode.getKey();
                    } else {
                        next = next.getParent();
                    }
                } else {
                    next = null;
                    return currentNode.getKey();
                }
            }
        } else {
            next = next.getRightNode();
            while (next.getLeftNode() != null) {
                next = next.getLeftNode();
            }
            return currentNode.getKey();
        }
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
