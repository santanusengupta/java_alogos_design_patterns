package dsa_practice.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    static class Node{
        int data;
        Node left;
        Node right;
        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        Node(int val){
            data = val;
            left = null;
            right = null;
        }

        Node(int x, Node left, Node right) {
            this.data = x;
            this.left = left;
            this.right = right;
        }

        public static void main(String[] args) {
            Node node = new Node(1);
            node.left = new Node(2);
            node.right = new Node(3);
            node.left.left = new Node(4);
            node.left.right = new Node(5);

            LevelOrderTraversal solution = new LevelOrderTraversal();
            List<List<Integer>> result = solution.levelOrder(node);

            System.out.println("Level Order Traversal of Tree:");

            // Printing the level order traversal result
            for (List<Integer> level : result) {
                printList(level);
            }
        }

        static void printList(List<Integer> list) {
            // Iterate through the
            // list and print each element
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            // If the tree is empty,
            // return an empty list
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++) {
                Node node = q.poll();
                if(node !=null) {
                    level.add(node.data);

                    if(node.left !=null) {
                        q.add(node.left);
                    }

                    if(node.right !=null){
                        q.add(node.right);
                    }
                }
            }
            ans.add(level);
        }
       return ans;
    }
}
