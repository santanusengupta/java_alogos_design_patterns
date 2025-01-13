package dsa_practice.binary_tree;

public class BinaryTreeSum {
    /*
    Given the root of a binary tree and an integer target, write a recursive function to determine if the tree
    has a root-to-leaf path where all the values along that path sum to the target.

    EXAMPLES
            Example 1:
// Example binary tree:
            //        4
            //      /   \
            //     2     7
            //    / \   /  \
            //   1   3 6    9
            Input:

            [4, 2, 7, 1, 3, 6, 9]
            target = 17
            Output: true (the path is 4 -> 7 -> 6)

            Example 2:

            //        4
            //      /   \
            //     2     7
            //    / \   /  \
            //   1   3 6    9
            Input:

            [4, 2, 7, 1, 3, 6, 9]
            target = 13
            Output: false
     */
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

        int totalSum = sumOfNodes(root);
        System.out.println("The sum of all nodes in the tree is: " + totalSum);
    }

    private static int sumOfNodes(TreeNode node){
        if(node == null) {
            return 0;
        }
        return node.val + sumOfNodes(node.left) + sumOfNodes(node.right);
    }
}
