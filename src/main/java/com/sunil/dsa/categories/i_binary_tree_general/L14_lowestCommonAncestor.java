package com.sunil.dsa.categories.i_binary_tree_general;

import com.sunil.dsa.core.TreeNode;

public class L14_lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root; // Found LCA
        }

        return (left != null) ? left : right; // Return non-null side
    }


}
