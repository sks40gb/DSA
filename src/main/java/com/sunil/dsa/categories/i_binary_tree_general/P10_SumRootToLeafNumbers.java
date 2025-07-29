package com.sunil.dsa.categories.i_binary_tree_general;

import com.sunil.dsa.core.TreeNode;

public class P10_SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return sum(root, "");
    }

    public int sum(TreeNode node, String sum){

        if(node.left == null && node.right == null){
            return Integer.parseInt(sum + node.val);
        }

        int total = 0;

        if(node.left != null){
            total += sum(node.left, sum + node.val);
        }

        if(node.right != null){
            total += sum(node.right, sum + node.val);
        }
        return total;

    }

}
