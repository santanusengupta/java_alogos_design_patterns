package dsa_practice.binary_tree;

public class FindTiltOfTree {
    private static int totalTilt = 0;
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

        int totalSum = findTiltOfTree(root);
        System.out.println("The sum of all nodes in the tree is: " + totalSum);
    }



    public static int findTiltOfTree(TreeNode root) {
        calculateSubtreeSum(root);
        return totalTilt;
    }

    private static int calculateSubtreeSum(TreeNode node) {
        // Base case: If the node is null, its subtree sum is 0
        if (node == null) {
            return 0;
        }

        // Recursively calculate the sum of the left and right subtrees
        int leftSum = calculateSubtreeSum(node.left);
        int rightSum = calculateSubtreeSum(node.right);

        // Calculate the tilt of the current node
        int tilt = Math.abs(leftSum - rightSum);

        // Add the current node's tilt to the total tilt
        totalTilt += tilt;

        // Return the sum of the current subtree
        return leftSum + rightSum + node.val;
    }


}
