package com.sunil.dsa.categories.i_binary_tree_general;

import com.sunil.dsa.core.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P7_ConnectNodes {

    public static void main(String[] args) {
        P7_ConnectNodes tree = new P7_ConnectNodes();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        tree.connect(root);
        System.out.println("Next pointers populated!");
    }

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            TreeNode prev = null;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (prev != null) {
                    prev.next = curr;
                }

                prev = curr;

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }

}