package com.sunil.dsa.categories.i_binary_tree_general;

import com.sunil.dsa.core.TreeNode;

public class P3_InvertBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        P3_InvertBinaryTree solution = new P3_InvertBinaryTree();

        TreeNode invertedRoot = solution.invertTree(root);

        System.out.println("Root after inversion: " + invertedRoot.val);
        // Output: 4
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        // Swap left and right subtrees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


}
