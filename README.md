# Binary Search Tree (BST)

This project implements a generic Binary Search Tree (BST) in Java. It demonstrates the following features:

- **Insertion and Deletion:** Add or remove elements while maintaining BST properties.
- **Traversal Methods:** In-order traversal for sorted output, and serialization for tree representation.
- **Balancing Check:** Verify if the tree is height-balanced.
- **Reversal:** Generate a reversed deep copy of the tree.
- **Height Calculation:** Determine the height of the tree.

## Usage

The tree supports any data type that implements `Comparable`, allowing for custom data storage with natural ordering.

### Example
```java
BinarySearchTree<Integer> bst = new BinarySearchTree<>();
bst.put(10);
bst.put(5);
bst.put(15);

System.out.println("Contains 10: " + bst.contains(10)); // true
System.out.println("Tree height: " + bst.height());
System.out.println("In-order Traversal: " + bst.inOrderTraversal());
```

## Author

Bridget Brinkman