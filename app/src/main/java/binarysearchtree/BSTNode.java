package binarysearchtree;

public class BSTNode<T extends Comparable<T>> {

    /**
     * Key held by this node
     */
    private T key;

    /**
     * Left child reference
     */
    private BSTNode<T> left;

    /**
     * Right child reference
     */
    private BSTNode<T> right;

    /**
     * Constructor that accepts the key to be held by the new node
     */
    public BSTNode(T k) {
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
    public BSTNode<T> getLeft() {
        return left;
    }

    /**
     * Getter for the right child
     *
     * @return Reference to the left child
     */
    public BSTNode<T> getRight() {
        return right;
    }

    /**
     * Setter for the left child
     *
     * @param l BTNode to set as the left child
     */
    public void setLeft(BSTNode<T> l) {
        left = l;
    }

    /**
     * Setter for the right child
     *
     * @param r BTNode to set as the right child
     */
    public void setRight(BSTNode<T> r) {
        right = r;
    }
}
