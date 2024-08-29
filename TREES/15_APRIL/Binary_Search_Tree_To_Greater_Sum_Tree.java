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
//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        TreeNode current = root;
        int sum = 0;
        while (current != null) {
            if (current.right != null) {
                TreeNode temp = current.right;
                while (temp.left != null && temp.left != current)
                    temp = temp.left;

                if (temp.left == current) {
                    temp.left = null;
                    int t = current.val;
                    current.val += sum;
                    sum += t;
                    current = current.left;
                } else {
                    temp.left = current;
                    current = current.right;
                }
            } else {
                int t = current.val;
                current.val += sum;
                sum += t;
                current = current.left;
            }
        }
        return root;
    }
}
