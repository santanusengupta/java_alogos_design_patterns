package dsa_practice.binary_tree;

public class DiameterOfBinaryTree {
    /*
        Given the root of a binary tree, write a recursive function to find the diameter of the tree.
        The diameter of a binary tree is the length of the longest path (# of edges) between any
        two nodes in a tree. This path may or may not pass through the root.
     */

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0; // Base case: Height of an empty subtree is 0
        }

        // Recursively calculate the height of left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Update the diameter (longest path seen so far)
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Example tree:
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

        DiameterOfBinaryTree treeDiameter = new DiameterOfBinaryTree();
        System.out.println("Diameter of the tree: " + treeDiameter.diameterOfBinaryTree(root)); // Output: 3
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
