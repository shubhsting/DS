// https://leetcode.com/problems/validate-binary-search-tree/description/
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
class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current)
                    temp = temp.right;
                if (temp.right == current) {
                    if (prev != null && prev.val >= current.val)
                        return false;
                    temp.right = null;
                    prev = current;
                    current = current.right;
                } else {
                    temp.right = current;
                    current = current.left;
                }
            } else {
                if (prev != null && prev.val >= current.val)
                    return false;
                prev = current;
                current = current.right;
            }
        }
        return true;
    }
}