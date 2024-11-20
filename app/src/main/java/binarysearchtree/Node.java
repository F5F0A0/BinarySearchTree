package binarysearchtree;

public class Node<T extends Comparable<T>> {

    /**
     * Key held by this node
     */
    private T key;

    /**
     * Left child reference
     */
    private Node<T> left;

    /**
     * Right child reference
     */
    private Node<T> right;

    /**
     * Constructor that accepts the key to be held by the new node
     */
    public Node(T k) {
        key = k;
    }

    /**
     * Getter for the key
     * 
     * @return Reference to the key
     */
    public T getKey() {
        return key;
    }

    /**
     * Getter for the left child
     *
     * @return Reference to the left child
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * Getter for the right child
     *
     * @return Reference to the left child
     */
    public Node<T> getRight() {
        return right;
    }

    /**
     * Setter for the left child
     *
     * @param l BTNode to set as the left child
     */
    public void setLeft(Node<T> l) {
        left = l;
    }

    /**
     * Setter for the right child
     *
     * @param r BTNode to set as the right child
     */
    public void setRight(Node<T> r) {
        right = r;
    }
}
