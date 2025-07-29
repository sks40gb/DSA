package com.sunil.dsa.categories.i_binary_tree_general;

import com.sunil.dsa.core.TreeNode;

import java.util.Stack;

public class P12_BSTIterator {

    private Stack<TreeNode> stack;

    public P12_BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** Pushes all left children onto the stack */
    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

}
