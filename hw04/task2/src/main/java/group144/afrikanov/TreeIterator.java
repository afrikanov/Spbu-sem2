package group144.afrikanov;

import java.sql.Types;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class realizes the AVL Tree iterator of a type
 *
 * @param <Type> Type you want to use in your AVL Tree
 */
public class TreeIterator <Type extends Comparable<Type>> implements Iterator<Type> {
    private AVLTree<Type>.Node<Type> next;

    TreeIterator(AVLTree<Type>.Node<Type> node) {
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
    public Type next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        AVLTree<Type>.Node<Type> currentNode = next;
        if (next.getRightNode() != null) {
            next = next.getRightNode();
            while (next.getLeftNode() != null) {
                next = next.getLeftNode();
            }
            return currentNode.getKey();
        }
        else {
            while (true) {
                if (next.getParent() == null) {
                    next = null;
                    return currentNode.getKey();
                }
                else {
                    if (next.getParent().getLeftNode() == next) {
                        next = next.getParent();
                        return currentNode.getKey();
                    }
                    else {
                        next = next.getParent();
                    }
                }
            }
        }
    }
}
