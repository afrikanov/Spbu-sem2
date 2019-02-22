package com.afrikanov;

/**
 * Class implements methods of a list.
 */
public class List {

    /**
     * Class implements structure with 2 fields : value and link on the next element.
     */
    class Node {
        private int value;
        private Node next;
        Node(int val, Node nxt) {
            value = val;
            next = nxt;
        }
    }
    Node Head = new Node(0, null);
    private int size = 0;

    /**
     * Method adds a new node after certain.
     * @param Item
     * @param NewItem
     */
    public void InsertAfter(Node Item, Node NewItem) {
        NewItem.next = Item.next;
        Item.next = NewItem;
        size++;
    }

    /**
     * Method removes a node after certain.
     * @param Item
     */
    public void RemoveAfter(Node Item) {
        if (Item.next != null) {
            Item.next = Item.next.next;
            size--;
        }
    }

    /**
     * Method removes a head of a list.
     */
    public void RemoveHead() {
        if (Head != null) {
            Head = Head.next;
        }
    }

    public boolean Empty() {
        return (size == 0);
    }

    /**
     * Method searches a node with certain value.
     * @param Value
     * @return Found node or null if it doesn't exist.
     */
    public Node Search(int Value) {
        Node Item = Head;
        while (Item.next != null && Value != Item.value) {
            Item = Item.next;
        }
        return Item;
    }
}
