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
// https://leetcode.com/problems/count-complete-tree-nodes/
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftH = leftHeight(root);
        int rightH = rightHeight(root);
        if (leftH == rightH)
            return (int) Math.pow(2, leftH) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int leftHeight(TreeNode root) {
        TreeNode current = root;
        int count = 1;
        while (current.left != null) {
            count++;
            current = current.left;
        }
        return count;
    }

    public int rightHeight(TreeNode root) {
        TreeNode current = root;
        int count = 1;
        while (current.right != null) {
            count++;
            current = current.right;
        }
        return count;
    }
}