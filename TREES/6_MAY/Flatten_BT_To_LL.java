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
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
class Solution {
    public void flatten(TreeNode root) {
        flatten2(root);
    }

    public TreeNode flatten2(TreeNode root) {
        if (root == null)
            return null;
        TreeNode leftEnd = flatten2(root.left);
        TreeNode rightEnd = flatten2(root.right);
        if (leftEnd != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            leftEnd.right = temp;
        }
        root.left = null;
        return rightEnd == null ? (leftEnd == null ? root : leftEnd) : rightEnd;
    }
}
