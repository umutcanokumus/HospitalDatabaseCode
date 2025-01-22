import java.util.ArrayList;
import java.util.List;

//--------------------------------------------------------
// Title: Binary Search Tree (BST) Class
// Author:Umutcan OKUMUŞ
// ID: 43057338238
// Section: 02
// Assignment: 3
// Description: This class implements a generic Binary Search Tree (BST) where
// values are stored in a sorted manner. It provides methods to add, retrieve,
// delete, and traverse nodes in ascending and descending orders.
//--------------------------------------------------------

public class BST<Value extends Comparable<Value>> {

    private BSTNode root; // Root node of the BST

    //--------------------------------------------------------
    // Summary: Constructs an empty Binary Search Tree.
    // Precondition: None.
    // Postcondition: A BST object is created with no nodes.
    //--------------------------------------------------------
    public BST() {
        root = null;
    }

    //--------------------------------------------------------
    // Summary: Represents a node in the Binary Search Tree.
    // Precondition: None.
    // Postcondition: A node is created with the given value, and its
    // left and right child references are initialized to null.
    //--------------------------------------------------------
    private class BSTNode {
        Value value;      // Value stored in the node
        BSTNode left;     // Reference to the left child
        BSTNode right;    // Reference to the right child

        public BSTNode(Value value) {
            this.value = value; // Initialize the value of the node
            this.left = null;   // Initialize the left child to null
            this.right = null;  // Initialize the right child to null
        }
    }

    //--------------------------------------------------------
    // Summary: Inserts a value into the BST.
    // Precondition: value is a non-null Comparable object.
    // Postcondition: The value is added to the BST in sorted order. If the value
    // already exists in the tree, it is overwritten.
    //--------------------------------------------------------
    public void put(Value value) {
        root = put(root, value);
    }

    //--------------------------------------------------------
    // Summary: Helper method to recursively insert a value into the BST.
    // Precondition: value is a non-null Comparable object.
    // Postcondition: The value is added in the correct position in the BST.
    //--------------------------------------------------------
    private BSTNode put(BSTNode x, Value value) {
        if (x == null) {
            return new BSTNode(value); // Create a new node if the current position is null
        }
        int cmp = value.compareTo(x.value); // Compare the new value with the current node's value
        if (cmp < 0) {
            x.left = put(x.left, value); // Insert into the left subtree
        } else if (cmp > 0) {
            x.right = put(x.right, value); // Insert into the right subtree
        } else {
            x.value = value; // Overwrite the value if it already exists
        }
        return x; // Return the current node
    }

    //--------------------------------------------------------
    // Summary: Retrieves a value from the BST.
    // Precondition: value is a non-null Comparable object.
    // Postcondition: Returns the value if found; otherwise, returns null.
    //--------------------------------------------------------
    public Value get(Value value) {
        BSTNode x = root;
        while (x != null) {
            int cmp = value.compareTo(x.value); // Compare the target value with the current node's value
            if (cmp < 0) {
                x = x.left; // Move to the left subtree if the value is smaller
            } else if (cmp > 0) {
                x = x.right; // Move to the right subtree if the value is larger
            } else {
                return x.value; // Value found, return it
            }
        }
        return null; // Return null if the value is not found
    }

    //--------------------------------------------------------
    // Summary: Deletes a value from the BST.
    // Precondition: value is a non-null Comparable object.
    // Postcondition: Removes the value from the BST if it exists. If the value is not
    // found, the tree remains unchanged.
    //--------------------------------------------------------
    public void delete(Value value) {
        root = delete(root, value);
    }

    //--------------------------------------------------------
    // Summary: Helper method to recursively delete a value from the BST.
    // Precondition: value is a non-null Comparable object.
    // Postcondition: Removes the node with the specified value, if it exists.
    //--------------------------------------------------------
    private BSTNode delete(BSTNode root, Value value) {
        if (root == null) return null; // Return null if the tree is empty

        int cmp = value.compareTo(root.value);
        if (cmp < 0) {
            root.left = delete(root.left, value); // Recur to the left subtree
        } else if (cmp > 0) {
            root.right = delete(root.right, value); // Recur to the right subtree
        } else {
            // Node to delete is found
            if (root.left == null) return root.right; // Case: Only right child or no child
            if (root.right == null) return root.left; // Case: Only left child
            // Case: Two children, replace with the smallest value in the right subtree
            root.value = minValue(root.right);
            root.right = delete(root.right, root.value); // Delete the successor
        }
        return root;
    }

    //--------------------------------------------------------
    // Summary: Helper method to find the minimum value in a subtree.
    // Precondition: root is a non-null node in the tree.
    // Postcondition: Returns the smallest value in the subtree.
    //--------------------------------------------------------
    private Value minValue(BSTNode root) {
        Value minValue = root.value;
        while (root.left != null) {
            root = root.left; // Move to the leftmost node
            minValue = root.value;
        }
        return minValue;
    }

    //--------------------------------------------------------
    // Summary: Performs an in-order traversal of the BST.
    // Precondition: None.
    // Postcondition: Returns a list of values in sorted ascending order.
    //--------------------------------------------------------
    public List<Value> inOrderTraversal() {
        List<Value> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    //--------------------------------------------------------
    // Summary: Helper method for recursive in-order traversal.
    // Precondition: None.
    // Postcondition: Populates the result list with values in ascending order.
    //--------------------------------------------------------
    private void inOrderTraversal(BSTNode root, List<Value> result) {
        if (root != null) {
            inOrderTraversal(root.left, result); // Recur to the left subtree
            result.add(root.value); // Add the current node's value
            inOrderTraversal(root.right, result); // Recur to the right subtree
        }
    }

    //--------------------------------------------------------
    // Summary: Performs a descending in-order traversal of the BST.
    // Precondition: None.
    // Postcondition: Returns a list of values in sorted descending order.
    //--------------------------------------------------------
    public List<Value> inOrderTraversalDesc() {
        List<Value> result = new ArrayList<>();
        inOrderTraversalDesc(root, result);
        return result;
    }

    //--------------------------------------------------------
    // Summary: Helper method for recursive descending in-order traversal.
    // Precondition: None.
    // Postcondition: Populates the result list with values in descending order.
    //--------------------------------------------------------
    private void inOrderTraversalDesc(BSTNode root, List<Value> result) {
        if (root != null) {
            inOrderTraversalDesc(root.right, result);
            result.add(root.value);
            inOrderTraversalDesc(root.left, result);
        }
    }

    //--------------------------------------------------------
    // Summary: Checks if the BST is empty.
    // Precondition: None.
    // Postcondition: Returns true if the BST contains no nodes; otherwise, false.
    //--------------------------------------------------------
    public boolean isEmpty() {
        return root == null;
    }
}