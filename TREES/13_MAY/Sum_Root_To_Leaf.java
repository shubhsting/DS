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
// https://leetcode.com/problems/sum-root-to-leaf-numbers/
class Solution {
    public int sumNumbers(TreeNode root) {
        int[] ans = new int[1];
        sum(root, 10, 0, ans);
        return ans[0];
    }

    public void sum(TreeNode root, int multiplier, int ansSoFar, int[] ans) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            ans[0] += ((ansSoFar * multiplier) + root.val);
            return;
        }

        sum(root.left, multiplier, (ansSoFar * multiplier) + root.val, ans);
        sum(root.right, multiplier, (ansSoFar * multiplier) + root.val, ans);
    }
}