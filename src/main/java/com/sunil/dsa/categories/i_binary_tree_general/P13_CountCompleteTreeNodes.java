package com.sunil.dsa.categories.i_binary_tree_general;

import com.sunil.dsa.core.TreeNode;

public class P13_CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == rightHeight) {

            // Left subtree is perfect, count all nodes + right subtree
            return (1 << leftHeight) + countNodes(root.right);
        } else {

            // Right subtree is perfect, count all nodes + left subtree
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    private int getHeight(TreeNode node) {

        int height = 0;

        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

}
