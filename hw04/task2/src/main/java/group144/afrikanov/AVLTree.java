package group144.afrikanov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static java.lang.Math.max;

/**
 * Realizes the AVL Tree data structure
 * @param <T> - T you want to use in your avl tree
 */
public class AVLTree<T extends Comparable<T>> implements Collection<T> {

    private Node<T> root = null;
    private int size = 0;

    /**
     * @param node - the root of a tree
     * @return a height of the tree with a root in a certain node
     */
    public int getHeight(Node<T> node) {
        return ((node != null) ? node.height : 0);
    }

    /** Returns difference between left and right nodes' heights */
    public int balanceFactor(Node<T> node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    /** Changes right or left node height */
    public void fixHeight(Node<T> node) {
        node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    /**
     * Realize right rotation
     * @param node in which realised rotate
     */
    public Node<T> rotateRight(Node<T> node) {
        Node<T> leftNode = node.left;
        node.left = leftNode.right;
        if (leftNode.right != null) {
            leftNode.right.parent = node;
        }
        leftNode.right = node;
        if (node.parent == null) {
            root = leftNode;
        } else {
            if (node.equals(node.parent.left)) {
                node.parent.left = leftNode;
            } else {
                node.parent.right = leftNode;
            }
        }
        leftNode.parent = node.parent;
        node.parent = leftNode;
        fixHeight(node);
        fixHeight(leftNode);
        return leftNode;
    }

    /**
     * Realize left rotation
     * @param node in which realised rotate
     */
    public Node<T> rotateLeft(Node<T> node) {
        Node<T> rightNode = node.right;
        node.right = rightNode.left;
        if (rightNode.left != null) {
            rightNode.left.parent = node;
        }
        rightNode.left = node;
        if (node.parent == null) {
            root = rightNode;
        } else {
            if (node.equals(node.parent.left)) {
                node.parent.left = rightNode;
            } else {
                node.parent.right = rightNode;
            }
        }
        rightNode.parent = node.parent;
        node.parent = rightNode;
        fixHeight(node);
        fixHeight(rightNode);
        return rightNode;
    }

    /**
     * Realize balance
     * @param node in which realised balance
     */
    public Node<T> balance(Node<T> node) {
        fixHeight(node);
        if (balanceFactor(node) == 2) {
            if (balanceFactor(node.right) < 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        } else if (balanceFactor(node) == -2) {
            if (balanceFactor(node.left) > 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }
        return node;
    }

    /** @return amount of elements in your tree */
    @Override
    public int size() {
        return size;
    }

    /** @return true is tree is empty, false otherwise */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** @return true if value contains in tree */
    public boolean isContains(T value, Node<T> node) {
        if (node == null) {
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
        return isContains((T) object, root);
    }

    /** @return tree iterator */
    @Override
    public Iterator<T> iterator() {
        return new TreeIterator<>(root);
    }

    /** @return array, which contains all elements of the collection in increasing order */
    @Override
    public Object[] toArray() {
        Object[] objectArray = new Object[size];
        return toArray(objectArray);
    }

    /**
     * Returns array, which contains all elements of the collection in increasing order
     * @param a in which element from the collection will be added
     * @param <T> T of the array
     */
    @Override
    public <T> T[] toArray(T[] a) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (var element : a) {
            arrayList.add((T)element);
        }
        return arrayList.toArray(a);
    }

    /**
     * Adds a value to the AVL Tree
     * @param value - value, which you want to add
     */
    public void addNode(Node<T> node, T value) {
        if (value.compareTo(node.key) > 0) {
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
    }

    /**
     * Method adds a value to your AVL Tree
     * @param value - value which you want to add
     * @return false, if the tree contains this value before adding, else true
     */
    @Override
    public boolean add(T value) {
        if (root == null) {
            root = new Node<>(value);
            return true;
        } else {
            if (contains(value)) {
                return false;
            }
            ++size;
            addNode(root, value);
            return true;
        }
    }

    /** @return the smallest element in a tree with a node as a root */
    public Node<T> findMin(Node<T> node) {
        return node.left != null ? findMin(node.left) : node;
    }

    /** Removes the smallest value from the AVL Tree */
    public Node<T> removeMin(Node<T> node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = removeMin(node.left);
        return balance(node);
    }

    /**
     * @param value - value which you want to find
     * @param node - root of a tree
     * @return a node with a certain value or null if it doesn't exists
     */
    public Node<T> findKey(T value, Node<T> node) {
        if (node == null) {
            return null;
        }
        if (value.compareTo((T) node) > 0) {
            return findKey(value, node.right);
        } else if (value.compareTo((T) node) < 0) {
            return findKey(value, node.left);
        } else {
            return node;
        }
    }

    /**
     * Method swap two nodes
     * @param node - first node which you want to swap
     * @param newNode - second node which you want to swap
     */
    private void swapNodes(Node<T> node, Node<T> newNode) {
        if (newNode == null) {
            if (node.parent == null) {
                root = null;
            } else {
                if (node.equals(node.parent.left)) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
            }
        } else {
            node.key = newNode.key;
            if (newNode.equals(newNode.parent.left)) {
                newNode.parent.left = null;
            } else {
                newNode.parent.right = null;
            }
        }
    }

    /**
     * Removes a value from the AVL Treeue, which you want to remove
     * @return false, if the tree doesn't contain this value, else true
     */
    private Node<T> removeNode(T value, Node<T> node) {
        Node<T> nodeRemove = findKey(value, node);
        if (nodeRemove == null) {
            return null;
        }
        Node<T> leftTree = nodeRemove.left, rightTree = nodeRemove.right;
        if (rightTree != null) {
            Node<T> minRightTree = findMin(rightTree);
            if (leftTree != null) {
                swapNodes(nodeRemove, minRightTree);
            } else {
                swapNodes(nodeRemove, rightTree);
            }
        } else {
            if (leftTree != null) {
                swapNodes(nodeRemove, leftTree);
            } else {
                swapNodes(nodeRemove, null);
            }
        }
        return balance(nodeRemove);
    }

    /**
     * Method removes element from tree
     * @param value of removing element
     */
    @Override
    public boolean remove(Object value) {
        if (contains(value)) {
            --size;
            removeNode((T) value, root);
            return true;
        }
        return false;
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
    public boolean addAll(Collection<? extends T> c) {
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
    public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        private T key;
        private int height = 1;
        private Node<T> left, right, parent;

        Node (T key, Node<T> parent) {
            this.key = key;
            left = right = null;
            this.parent = parent;
        }

        Node (T key) {
            this.key = key;
            left = right = null;
            this.parent = null;
        }

        public T getKey() {
            return key;
        }

        public Node<T> getParent() {
            return parent;
        }

        public Node<T> getLeftNode() {
            return left;
        }

        public Node<T> getRightNode() {
            return right;
        }

        @Override
        public int compareTo(Node<T> node) {
            return key.compareTo(node.key);
        }
    }
}
