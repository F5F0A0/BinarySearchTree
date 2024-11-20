package binarysearchtree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class AppTest {
    private BinarySearchTree<Integer> bst;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    public void testInsertAndContains() {
        bst.put(10);
        bst.put(5);
        bst.put(15);
        assertTrue(bst.contains(10), "Tree should contain 10");
        assertTrue(bst.contains(5), "Tree should contain 5");
        assertTrue(bst.contains(15), "Tree should contain 15");
        assertFalse(bst.contains(20), "Tree should not contain 20");
    }

    @Test
    public void testHeight() {
        assertEquals(0, bst.height(), "Height of empty tree should be 0");
        bst.put(10);
        assertEquals(1, bst.height(), "Height of single-node tree should be 1");
        bst.put(5);
        bst.put(15);
        assertEquals(2, bst.height(), "Height of tree with 3 nodes should be 2");
    }

    @Test
    public void testIsBalanced() {
        assertTrue(bst.isBalanced(), "Empty tree should be balanced");
        bst.put(10);
        bst.put(5);
        bst.put(15);
        assertTrue(bst.isBalanced(), "Tree with nodes {10, 5, 15} should be balanced");
        bst.put(1);
        bst.put(0);
        assertFalse(bst.isBalanced(), "Tree with nodes {10, 5, 15, 1, 0} should not be balanced");
    }

    @Test
    public void testInOrderTraversal() {
        bst.put(10);
        bst.put(5);
        bst.put(15);
        bst.put(3);
        bst.put(7);
        assertEquals("3:5:7:10:15", bst.inOrderTraversal(), "In-order traversal should produce sorted output");
    }

    @Test
    public void testSerialize() {
        bst.put(10);
        bst.put(5);
        bst.put(15);
        assertEquals("R(10),L(5),L(15)", bst.serialize(), "Serialized output should represent the tree structure");
    }

    @Test
    public void testReverse() {
        bst.put(10);
        bst.put(5);
        bst.put(15);
        BinarySearchTree<Integer> reversed = bst.reverse();
        assertEquals("15:10:5", reversed.inOrderTraversal(), "Reversed tree should have keys in descending order");
        assertEquals("R(10),L(15),L(5)", reversed.serialize(), "Reversed serialized tree should be correct");
    }

    @Test
    public void testDeleteLeafNode() {
        bst.put(10);
        bst.put(5);
        bst.put(15);
        bst.delete(5);
        assertFalse(bst.contains(5), "Tree should not contain 5 after deletion");
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        bst.put(10);
        bst.put(5);
        bst.put(15);
        bst.put(3);
        bst.delete(5);
        assertFalse(bst.contains(5), "Tree should not contain 5 after deletion");
        assertTrue(bst.contains(3), "Tree should still contain 3");
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        bst.put(10);
        bst.put(5);
        bst.put(15);
        bst.put(3);
        bst.put(7);
        bst.delete(5);
        assertFalse(bst.contains(5), "Tree should not contain 5 after deletion");
        assertTrue(bst.contains(3), "Tree should still contain 3");
        assertTrue(bst.contains(7), "Tree should still contain 7");
    }

    @Test
    public void testDeepCopy() {
        bst.put(10);
        bst.put(5);
        bst.put(15);
        BinarySearchTree<Integer> copy = bst.reverse();
        assertEquals(bst.serialize(), copy.reverse().serialize(), "Reverse of reversed copy should match the original tree");
    }
}