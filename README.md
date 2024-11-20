# Binary Search Tree (BST)

This project implements a generic Binary Search Tree (BST) in Java, designed to efficiently store, retrieve, and manipulate data in sorted order.

---

## Features

- **Insertion and Deletion**:
  - Add or remove elements while maintaining the BST properties.
  
- **Traversal Methods**:
  - Perform in-order traversal to retrieve a sorted list of elements.
  - Serialize the tree for easy representation and debugging.

- **Balancing Check**:
  - Verify if the tree is height-balanced (difference in height between subtrees is no more than 1).

- **Reversal**:
  - Generate a reversed deep copy of the tree, flipping left and right subtrees.

- **Height Calculation**:
  - Compute the height of the tree for analysis.

---

## Usage

The `BinarySearchTree` class supports any data type that implements `Comparable`, enabling custom data storage with natural ordering. Below is an example of how to use the BST:

### Example Usage
```java
// Create a new Binary Search Tree
BinarySearchTree<Integer> bst = new BinarySearchTree<>();

// Insert elements
bst.put(10);
bst.put(5);
bst.put(15);

// Check if an element exists
System.out.println("Contains 10: " + bst.contains(10)); // true

// Get the height of the tree
System.out.println("Tree height: " + bst.height());

// Perform in-order traversal
System.out.println("In-order Traversal: " + bst.inOrderTraversal());
```

---

## Key Methods

- `put(T key)`: Inserts a new element into the BST.
- `delete(T key)`: Removes an element while maintaining BST properties.
- `contains(T key)`: Checks if an element exists in the tree.
- `inOrderTraversal()`: Returns a sorted list of elements in the tree.
- `height()`: Calculates the height of the tree.
- `isBalanced()`: Checks if the tree is height-balanced.
- `reverse()`: Returns a reversed copy of the BST.

---

## Author
**Bridget Brinkman**  
GitHub: [@F5F0A0](https://github.com/F5F0A0)  
Project for **CS1501 - Algorithms and Data Structures II**, Fall 2024.