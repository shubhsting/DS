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
// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
class Solution {
    class PathPair {
        int leftPath;
        int rightPath;

        PathPair(int leftPath, int rightPath) {
            this.rightPath = rightPath;
            this.leftPath = leftPath;
        }
    }

    public int longestZigZag(TreeNode root) {
        int[] ans = new int[1];
        PathPair rootPath = longestZigZag(root, ans);
        ans[0] = Math.max(ans[0], Math.max(rootPath.leftPath, rootPath.rightPath));
        return ans[0];
    }

    public PathPair longestZigZag(TreeNode root, int[] ans) {
        if (root == null)
            return new PathPair(-1, -1);
        PathPair left = longestZigZag(root.left, ans);
        PathPair right = longestZigZag(root.right, ans);
        int currentLeftPath = left.rightPath + 1;
        int currentRightPath = right.leftPath + 1;
        ans[0] = Math.max(ans[0], Math.max(currentLeftPath, currentRightPath));
        return new PathPair(currentLeftPath, currentRightPath);
    }
}