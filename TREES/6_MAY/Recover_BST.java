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
// https://leetcode.com/problems/recover-binary-search-tree/description/
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode current = root;
        TreeNode prev = null;
        TreeNode firstNode = null;
        TreeNode secondNode = null;

        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current)
                    temp = temp.right;
                if (temp.right != null) {
                    if (prev != null && prev.val > current.val) {
                        if (firstNode == null)
                            firstNode = prev;
                        secondNode = current;
                    }
                    prev = current;
                    temp.right = null;
                    current = current.right;
                } else {
                    temp.right = current;
                    current = current.left;
                }
            } else {
                if (prev != null && prev.val > current.val) {
                    if (firstNode == null)
                        firstNode = prev;
                    secondNode = current;
                }
                prev = current;
                current = current.right;
            }
        }

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
}
