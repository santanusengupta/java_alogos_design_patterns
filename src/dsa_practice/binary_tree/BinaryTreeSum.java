package dsa_practice.binary_tree;

public class BinaryTreeSum {

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
