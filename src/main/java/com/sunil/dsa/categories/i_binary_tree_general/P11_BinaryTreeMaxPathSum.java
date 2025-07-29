package com.sunil.dsa.categories.i_binary_tree_general;

import com.sunil.dsa.core.TreeNode;

public class P11_BinaryTreeMaxPathSum {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        // Compute left and right max path sums, ignoring negative values
        int leftSum = Math.max(0, dfs(node.left));
        int rightSum = Math.max(0, dfs(node.right));

        // Compute the max path sum with this node as the root
        int currentMax = node.val + leftSum + rightSum;

        // Update global max sum
        maxSum = Math.max(maxSum, currentMax);

        // Return max path sum including this node
        return node.val + Math.max(leftSum, rightSum);
    }

}
