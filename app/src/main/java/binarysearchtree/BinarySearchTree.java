/**
 * Binary Search Tree (BST) Implementation.
 * 
 * @author Bridget Brinkman
 * @param <T> The type of the elements stored in the tree, which must extend Comparable
 */

package binarysearchtree;

public class BinarySearchTree<T extends Comparable<T>>{

    private Node<T> root;

    /**
     * Inserts a new key into the Binary Search Tree.
     *
     * @param key The key to be inserted into the tree
     */
    public void put(T key) {
        root = put(root, key);
    }

    /**
     * Helper method to recursively insert a key into the tree.
     *
     * @param cur The current node during the traversal
     * @param key The key to be inserted
     * @return The updated node after insertion
     */
    private Node<T> put(Node<T> cur, T key) {
        if (cur == null) {
            return new Node<T>(key);
        }
        int cmp = key.compareTo(cur.getKey());
        if (cmp < 0) {
            cur.setLeft(put(cur.getLeft(), key));
        } else if (cmp > 0) {
            cur.setRight(put(cur.getRight(), key));
        } else {
            // key already exists; do nothing
        }
        return cur;
    }

    /**
     * Checks if the Binary Search Tree contains the specified key.
     *
     * @param key The key to search for
     * @return true if the tree contains the key, false otherwise
     */
    public boolean contains(T key) {
        return contains(root, key);
    }

    /**
     * Helper method to recursively check if a key exists in the tree.
     *
     * @param cur The current node during the traversal
     * @param key The key to search for
     * @return true if the key is found, false otherwise
     */
    private boolean contains(Node<T> cur, T key) {
        if (cur == null) {
            return false;
        }
        int cmp = key.compareTo(cur.getKey());
        if (cmp < 0) {
            return contains(cur.getLeft(), key);
        } else if (cmp > 0) {
            return contains(cur.getRight(), key);
        } else {
            return true;
        }
    }

    /**
     * Deletes a key from the Binary Search Tree.
     *
     * @param key The key to be deleted
     */
    public void delete(T key) {
        root = delete(root, key, null);
    }

    /**
     * Helper method to recursively delete a node from the tree.
     *
     * @param cur    The current node during the traversal
     * @param key    The key to be deleted
     * @param parent The parent node of the current node
     * @return The updated node after deletion
     */
    private Node<T> delete(Node<T> cur, T key, Node<T> parent) {
        if (cur == null) {
            return null;
        }
        int cmp = key.compareTo(cur.getKey());
        if (cmp < 0) {
            cur.setLeft(delete(cur.getLeft(), key, cur));
        } else if (cmp > 0) {
            cur.setRight(delete(cur.getRight(), key, cur));
        } else { // found the node to delete
            // case 1: leaf node (no children)
            if (cur.getLeft() == null && cur.getRight() == null) {
                if (parent == null) {
                    return null; // special case: deleting the root when it is a leaf
                }
                if (parent.getLeft() == cur) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
                return null;
            }
            // case 2: 1 child
            if (cur.getLeft() == null) {
                return cur.getRight(); // return the child
            } else if (cur.getRight() == null) {
                return cur.getLeft(); // return the child
            }
            // case 3: 2 children
            // find the successor (smallest node in the right subtree)
            Node<T> successor = findMin(cur.getRight());
            Node<T> successorParent = findParent(successor, cur);
            // if successor is not the direct right child of cur, move its subtree
            if (successorParent != cur) {
                successorParent.setLeft(successor.getRight());
                successor.setRight(cur.getRight());
            }
            // set the left child of the successor to the current node's left child
            successor.setLeft(cur.getLeft());
            // update the parent's reference to the successor
            if (parent == null) {
                return successor; // special case: root is being deleted
            } else if (parent.getLeft() == cur) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            return successor;
        }
        return cur;
    }

    /**
     * Helper method to find the minimum node in a subtree.
     *
     * @param node The root of the subtree
     * @return The node with the smallest key in the subtree
     */
    private Node<T> findMin(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * Helper method to find the parent of a given node.
     *
     * @param node The node to find the parent for
     * @param cur  The current node during traversal
     * @return The parent node of the specified node
     */
    private Node<T> findParent(Node<T> node, Node<T> cur) {
        if (cur == null || cur.getLeft() == node || cur.getRight() == node) {
            return cur;
        }
        if (node.getKey().compareTo(cur.getKey()) < 0) {
            return findParent(node, cur.getLeft());
        } else {
            return findParent(node, cur.getRight());
        }
    }

    /**
     * Computes the height of the Binary Search Tree.
     *
     * @return The height of the tree (a single node tree has a height of 1, an empty tree has a height of 0)
     */
    public int height() {
        return height(root);
    }

    /**
     * Helper method to recursively compute the height of a subtree.
     *
     * @param cur The root of the subtree
     * @return The height of the subtree
     */
    private int height(Node<T> cur) {
        if (cur == null) {
            return 0;
        }
        return Math.max(height(cur.getLeft()), height(cur.getRight())) + 1;
    }

    /**
     * Determines if the Binary Search Tree is height-balanced.
     *
     * @return true if the tree is balanced, false otherwise
     */
    public boolean isBalanced() {
        // return isBalanced(root);
        return isBalanced(root) != -1;
    }

    /**
     * Helper method to check if a subtree is height-balanced.
     * 
     * The method returns the height of the subtree if it is balanced, and -1 if it is not.
     * 
     * @param cur The root of the subtree
     * @return The height of the subtree, or -1 if the subtree is not balanced
     */
    private int isBalanced(Node<T> cur) {
        if (cur == null) {
            return 0;
        }
        int leftHeight = isBalanced(cur.getLeft());
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = isBalanced(cur.getRight());
        if (rightHeight == -1) {
            return -1;
        }
    
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Performs an in-order traversal of the Binary Search Tree.
     *
     * @return A colon-separated string containing the keys in ascending order
     */
    public String inOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(root, sb);
        return sb.toString();
    }

    /**
     * Helper method to recursively perform in-order traversal on a subtree.
     *
     * @param cur The root of the subtree
     * @param sb  The StringBuilder used to construct the result
     */
    private void inOrderTraversal(Node<T> cur, StringBuilder sb) {
        if (cur == null) {
            return;
        }
        inOrderTraversal(cur.getLeft(), sb);
        if (sb.length() > 0) {
            sb.append(":");
        }
        sb.append(cur.getKey().toString());
        inOrderTraversal(cur.getRight(), sb);
    }

    /**
     * Produces a serialized string representation of the Binary Search Tree.
     *
     * @return A string representing the tree in pre-order traversal
     */
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /**
     * Helper method to recursively serialize a subtree.
     *
     * @param cur The root of the subtree
     * @param sb  The StringBuilder used to construct the result
     */
    private void serialize(Node<T> cur, StringBuilder sb) {
        if (cur == null) {
            return;
        }
        // append the root, internal, or leaf node information
        if (cur == root) {
            sb.append("R(" + cur.getKey().toString() + ")");
        } else if (cur.getLeft() != null || cur.getRight() != null) {
            sb.append(",I(").append(cur.getKey().toString()).append(")");
        } else {
            sb.append(",L(").append(cur.getKey().toString()).append(")");
        }
        // recursively serialize the left child
        if (cur.getLeft() != null) {
            serialize(cur.getLeft(), sb); // after returning from serializing the left tree, we must check if the right
                                          // child is null
            if (cur.getRight() == null) {
                sb.append(",X(NULL)"); // add X(NULL) if the right child is null
            }
        } else if (cur.getRight() != null) { // case where cur.getLeft() == null, we must append X(NULL)
            sb.append(",X(NULL)");
        }
        // recursively serialize the right child
        if (cur.getRight() != null) {
            serialize(cur.getRight(), sb);
        }
    }

    /**
     * Produces a deep copy of the Binary Search Tree that is reversed.
     * Left children hold keys greater than the current key, right children hold keys less than the current key.
     *
     * @return A reversed deep copy of the Binary Search Tree
     */
    public BinarySearchTree<T> reverse() {
        BinarySearchTree<T> reversedTree = new BinarySearchTree<>();
        reversedTree.root = reverse(root);
        return reversedTree;
    }

    /**
     * Helper method to recursively reverse a subtree.
     *
     * @param cur The root of the subtree
     * @return The new reversed node
     */
    private Node<T> reverse(Node<T> cur) {
        if (cur == null) {
            return null;
        }
        Node<T> newNode = new Node<>(cur.getKey());
        newNode.setLeft(reverse(cur.getRight()));
        newNode.setRight(reverse(cur.getLeft()));
        return newNode;
    }  
}
