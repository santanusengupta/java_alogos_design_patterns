package dsa_practice.binary_tree;

public class FindGoodNodes {
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
        //       5
        //      / \
        //     4   8
        //    /   / \
        //   11  13  4
        //  /  \      \
        // 7    2      1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int result = countGoodNodes(root);
        System.out.println("Number of good nodes: " + result);
    }

    private static int countGoodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        return dfs(root,root.val);
    }

    private static int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int goodNodeCount = 0;

        // Check if the current node is "good"
        if (node.val >= maxSoFar) {
            goodNodeCount++;
            maxSoFar = node.val; // Update maxSoFar for this path
        }

        // Recurse for left and right subtrees
        goodNodeCount += dfs(node.left, maxSoFar);
        goodNodeCount += dfs(node.right, maxSoFar);

        return goodNodeCount;
    }
}
