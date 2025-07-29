package com.sunil.dsa.categories.i_binary_tree_general;

import com.sunil.dsa.core.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P6_ConstructBinaryTree_II {
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Build a value → index map for inorder traversal
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRootIdx = inorderIndexMap.get(rootVal);
        int leftTreeSize = inRootIdx - inStart;

        root.left = build(inorder, inStart, inRootIdx - 1,
                postorder, postStart, postStart + leftTreeSize - 1);

        root.right = build(inorder, inRootIdx + 1, inEnd,
                postorder, postStart + leftTreeSize, postEnd - 1);
        return root;
    }

}
