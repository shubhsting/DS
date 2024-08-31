/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// https://leetcode.com/problems/inorder-successor-in-bst/
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode current = root;
        TreeNode previous = null;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current)
                    temp = temp.right;

                if (temp.right == current) {
                    if (previous == p)
                        return current;
                    previous = current;
                    temp.right = null;
                    current = current.right;
                } else {
                    temp.right = current;
                    current = current.left;
                }
            } else {
                if (previous == p)
                    return current;
                previous = current;
                current = current.right;
            }
        }
        return null;
    }
}