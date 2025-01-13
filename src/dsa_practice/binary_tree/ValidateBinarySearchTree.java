package dsa_practice.binary_tree;

public class ValidateBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        // Example binary tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        boolean validBst = isValidBST(root);
        System.out.println("This tree is a binary tree: " + validBst);
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Integer min, Integer max) {
        // Base case: If the node is null, it is a valid BST
        if (node == null) {
            return true;
        }

        // Check if the current node's value violates the BST property
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // Recursively check the left and right subtrees with updated bounds
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }


}
