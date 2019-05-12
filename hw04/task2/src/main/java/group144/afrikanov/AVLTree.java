package group144.afrikanov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static java.lang.Math.max;
/**
 * Realizes the AVL Tree data structure
 * @param <Type> - T you want to use in your avl tree
 */
public class AVLTree<Type extends Comparable<Type>> implements Collection<Type> {

    private Node<Type> root = null;
    private int size = 0;

    public Node<Type> getRoot() {
        return root;
    }

    public Type getRootKey() {
        if (root != null) {
            return root.key;
        }
        return null;
    }

    /** @return amount of elements in your tree */
    @Override
    public int size() {
        return size;
    }

    public String print() {
        if (isEmpty()) {
            return "null";
        }
        return root.print();
    }

    /** @return true is tree is empty, false otherwise */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** @return true if value contains in tree */
    private boolean isContains(Type value, Node<Type> node) {
        if (node == null || node.key == null) {
            return false;
        }
        if (node.key.compareTo(value) == 0) {
            return true;
        } else if (node.key.compareTo(value) > 0) {
            return isContains(value, node.left);
        } else {
            return isContains(value, node.right);
        }
    }

    /**
      * @param object to check for contains
      * @return if the object contains in tree
     */
    @Override
    public boolean contains(Object object) {
        return isContains((Type) object, root);
    }

    /** @return tree iterator */
    @Override
    public Iterator<Type> iterator() {
        return new TreeIterator<>(root);
    }

    /** @return array, which contains all elements of the collection */
    @Override
    public Object[] toArray() {
        Object[] objectArray = new Object[size];
        return toArray(objectArray);
    }

    /**
     * Returns array, which contains all elements of the collection
     * @param a in which element from the collection will be added
     * @param <T> T of the array
     */
    @Override
    public <T> T[] toArray(T[] a) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (var element : this) {
            arrayList.add((T)element);
        }
        return arrayList.toArray(a);
    }

    /**
     * Adds a value to the AVL Tree
     * @param value - value, which you want to add
     */
    private void addNode(Node<Type> node, Type value) {
        if (value.compareTo(node.key) < 0) {
            if (node.left == null) {
                node.left = new Node<>(value, node);
            } else {
                addNode(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(value, node);
            } else {
                addNode(node.right, value);
            }
        }
        node.balance();
    }

    /**
     * Method adds a value to your AVL Tree
     * @param value - value which you want to add
     * @return false, if the tree contains this value before adding, else true
     */
    @Override
    public boolean add(Type value) {
        if (root == null) {
            root = new Node<>(value);
            ++size;
            return true;
        } else {
            if (contains(value)) {
                return false;
            }
            addNode(root, value);
            ++size;
            return true;
        }
    }

    /**
     * Method removes element from tree
     * @param value of removing element
     * @return true, if value contains in the tree, false in other way
     */
    @Override
    public boolean remove(Object value) {
        if (contains(value)) {
            root.removeNode((Type) value, this);
            --size;
            return true;
        }
        return false;
    }

    /**
     * Method removes the smallest element in the tree with root in certain node
     * @param node - root of the tree
     */
    private void removeMin(Node<Type> node) {
        if (node.left == null) {
            if (node.right != null) {
                node.right.parent = node.parent.left;
            }
        }
        removeMin(node.left);
        node.balance();
    }

    /**
     * @param c to be checked for containment in this collection
     * @return if this collection contains all elements from stated collection
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    /** Method adds elements from collection to the tree */
    @Override
    public boolean addAll(Collection<? extends Type> c) {
        for (var element : c) {
            if (!add(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     *  @param c of elements to be removed from this collection
     *  @return if all elements from stated collection will be removed from this collection? false otherwise
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        for (var element : c) {
            if (!remove(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Removing all elements of stated collection from this collection
     * @param c to get elements
     * @return true if something is deleted
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean answer = false;
        for (Object element : c) {
            if (!contains(element)) {
                remove(element);
                answer = true;
            }
        }
        return answer;
    }

    /** Method makes the tree empty */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Class realizes the structure of the Node in the tree */
    private class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        private T key;
        private int height = 1;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;

        private Node (T key, Node<T> parent) {
            this.key = key;
            left = right = null;
            this.parent = parent;
        }

        private Node (T key) {
            this.key = key;
            left = right = null;
            this.parent = null;
        }

        /** @return the smallest element in a tree with a certain node as a root */
        private Node<T> findMin() {
            return this.left != null ? this.left.findMin() : this;
        }

        private String print() {
            TreeIterator<Integer> iterator = new TreeIterator<Integer>((AVLTree<Integer>.Node<Integer>)root);
            StringBuilder answer = new StringBuilder();
            while (iterator.hasNext()) {
                answer.append(iterator.next()).append(" ");
            }
            return answer.toString();
        }

        /**
         * Method removes a node from the tree by the value
         * @param value - value of the node you want to remove
         */
        private void removeNode(T value, AVLTree<T> tree) {
            if (value.compareTo(this.key) > 0) {
                this.right.removeNode(value, tree);
            } else if (value.compareTo(this.key) < 0) {
                this.left.removeNode(value, tree);
            } else {
                Node<T> leftTree = this.left;
                Node<T> rightTree = this.right;
                if (rightTree == null) {
                    if (leftTree == null) {
                        if (this.parent != null) {
                            if (this == this.parent.left) {
                                this.parent.left = null;
                            } else {
                                this.parent.right = null;
                            }
                        } else {
                            tree.root = null;
                        }
                    } else {
                        this.key = this.left.key;
                        if (this.parent != null) {
                            this.parent = this.left;
                        }
                        this.left = null;
                    }
                } else {
                    if (leftTree == null) {
                        this.key = this.right.key;
                        if (this.parent != null) {
                            this.parent = this.right;
                        }
                        this.right = null;
                    } else {
                        Node<T> smallestNode = rightTree.findMin();
                        removeMin((Node<Type>) rightTree);
                        this.key = smallestNode.key;
                    }
                }
            }
        }

        /** Method realizes balancing of the tree */
        private void balance() {
            this.fixHeight();
            if (this.balanceFactor() == -2) {
                if (this.right.balanceFactor() > 0) {
                    this.right.rotateRight();
                }
                this.rotateLeft();
            } else if (this.balanceFactor() == 2) {
                if (this.left.balanceFactor() < 0) {
                    this.left.rotateLeft();
                }
                this.rotateRight();
            }
        }

        /** Method realizes right rotation */
        private void rotateRight() {
            Node<T> leftNode = this.left;
            this.left = leftNode.right;
            if (leftNode.right != null) {
                leftNode.right.parent = this;
            }
            leftNode.right = this;
            if (this.parent == null) {
                root = (Node<Type>) leftNode;
            } else {
                if (this.equals(this.parent.left)) {
                    this.parent.left = leftNode;
                } else {
                    this.parent.right = leftNode;
                }
            }
            leftNode.parent = this.parent;
            this.parent = leftNode;
            this.fixHeight();
            leftNode.fixHeight();
        }

        /** Method realizes left rotation */
        private void rotateLeft() {
            Node<T> rightNode = this.right;
            this.right = rightNode.left;
            if (rightNode.left != null) {
                rightNode.left.parent = this;
            }
            rightNode.left = this;
            if (this.parent == null) {
                root = (Node<Type>) rightNode;
            } else {
                if (this.equals(this.parent.left)) {
                    this.parent.left = rightNode;
                } else {
                    this.parent.right = rightNode;
                }
            }
            rightNode.parent = this.parent;
            this.parent = rightNode;
            this.fixHeight();
            rightNode.fixHeight();
        }

        /** Returns difference between left and right nodes' heights */
        private int balanceFactor() {
            return (this.left == null ? 0 : this.left.height) - (this.right == null ? 0 : this.right.height);
        }

        /** Changes right or left node height */
        private void fixHeight() {
            this.height = max(this.left == null ? 0 : this.left.height, this.right == null ? 0 : this.right.height) + 1;
        }

        /** Method compares 2 nodes */
        @Override
        public int compareTo(Node<T> node) {
            return this.key.compareTo(node.key);
        }
    }

    /**
     * Class realizes the AVL Tree iterator of a T type
     * @param <T> T you want to use in your AVL Tree
     */
    public static class TreeIterator <T extends Comparable<T>> implements Iterator<T> {

        private AVLTree<T>.Node<T> next;
        String exceptionText = "No next element";

        TreeIterator(AVLTree<T>.Node<T> node) {
            if (node == null) {
                return;
            }
            next = node;
            while (next.left != null) {
                next = next.left;
            }
        }

        /**
         * Method finds the element of the tree after certain
         * @return next element of the tree
         * @throws NoNextElementException when there is no next element
         */
        @Override
        public T next() throws NoNextElementException {
            AVLTree<T>.Node<T> currentNode = next;
            if (!hasNext()) {
                throw new NoNextElementException(exceptionText);
            }
            if (next.right == null) {
                while (true) {
                    if (next.parent != null) {
                        if (next.parent.left == next) {
                            next = next.parent;
                            return currentNode.key;
                        } else {
                            next = next.parent;
                        }
                    } else {
                        next = null;
                        return currentNode.key;
                    }
                }
            } else {
                next = next.right;
                while (next.left != null) {
                    next = next.left;
                }
                return currentNode.key;
            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }
    }
}
