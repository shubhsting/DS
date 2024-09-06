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
// https://leetcode.com/problems/closest-binary-search-tree-value/
class Solution {
    public int closestValue(TreeNode root, double target) {
        int[] ans = new int[1];
        ans[0] = root.val;
        cl(root, target, ans);
        return ans[0];
    }

    public void cl(TreeNode root, double target, int[] ans) {
        if (root == null)
            return;
        if (Math.abs(root.val - target) < Math.abs(ans[0] - target))
            ans[0] = root.val;
        else if (Math.abs(root.val - target) == Math.abs(ans[0] - target))
            ans[0] = Math.min(ans[0], root.val);

        if (root.val - target > 0) {
            cl(root.left, target, ans);
        } else {
            cl(root.right, target, ans);
        }
    }
}