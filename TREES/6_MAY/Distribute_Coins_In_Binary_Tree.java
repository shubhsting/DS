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
//https://leetcode.com/problems/distribute-coins-in-binary-tree/
class Solution {
    class Edge {

    }

    public int distributeCoins(TreeNode root) {
        int[] ans = new int[1];
        distributeCoins(root, ans);
        return ans[0];
    }

    public int distributeCoins(TreeNode root, int[] ans) {
        if (root == null)
            return 0;

        int left = distributeCoins(root.left, ans);
        int right = distributeCoins(root.right, ans);

        ans[0] += Math.abs(left) + Math.abs(right);
        return left + right + root.val - 1;
    }
}