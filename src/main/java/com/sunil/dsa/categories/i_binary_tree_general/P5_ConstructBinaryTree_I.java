package com.sunil.dsa.categories.i_binary_tree_general;

import com.sunil.dsa.core.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P5_ConstructBinaryTree_I {

    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Build a value → index map for inorder traversal
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];

        TreeNode root = new TreeNode(rootVal);
        int inRootIdx = inorderIndexMap.get(rootVal);
        int leftTreeSize = inRootIdx - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftTreeSize,
                inorder, inStart, inRootIdx - 1);

        root.right = build(preorder, preStart + leftTreeSize + 1, preEnd,
                inorder, inRootIdx + 1, inEnd);
        return root;
    }

}
