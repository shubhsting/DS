/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
//https://leetcode.com/problems/binary-tree-maximum-path-sum/
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        maxP(root, ans);
        return ans[0];
    }

    public int maxP(TreeNode root, int[] ans) {
        if (root == null)
            return 0;
        int pathEndingAtLeftNode = maxP(root.left, ans);
        int pathEndingAtRightNode = maxP(root.right, ans);
        int maxPathEndingAtCurrentNode = Math
                .max(Math.max(pathEndingAtLeftNode + root.val, pathEndingAtRightNode + root.val), root.val);
        ans[0] = Math.max(Math.max(ans[0], maxPathEndingAtCurrentNode),
                pathEndingAtLeftNode + pathEndingAtRightNode + root.val);
        return maxPathEndingAtCurrentNode;
    }
}