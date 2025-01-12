package dsa_practice.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class preOrderTraversal {

    // Node class for the binary tree
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int val){
            data = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting preorder traversal
        List<Integer> result = preOrder(root);

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    private static List<Integer> preOrder(Node root) {

        List<Integer> arr = new ArrayList<>();
        preOrder(root,arr);
        return arr;

    }

    private static void preOrder(Node root, List<Integer> arr) {

        if(root == null){
            return;
        }

        arr.add(root.data);
        preOrder(root.left, arr);
        preOrder(root.right,arr);

    }


}
