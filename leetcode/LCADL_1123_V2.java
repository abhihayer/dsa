package com.example.dsa_java.dsa.leetcode;

public class LCADL_1123_V2 {
    private TreeNode lca = null;
    private int maxDepth = 0;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxDepth = getMaxDepth(root);
        dfs(root, 0);
        return lca;
    }

    // find the maximum depth exists in the  tree
    private int getMaxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getMaxDepth(node.left), getMaxDepth(node.right)) + 1;
    }

    // converge the nodes while propogating the immidiate max depths from nodes up and assigning value in lca. 
    private int dfs(TreeNode node, int depth) {
        if (node == null) return depth;

        int left = dfs(node.left, depth + 1);
        int right = dfs(node.right, depth + 1);
        
        if (left == right && left == maxDepth) {
            lca = node;
        }

        return Math.max(left, right);
    }

}
