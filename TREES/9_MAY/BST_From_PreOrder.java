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
// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
class Solution {
    int index;

    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return bstPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode bstPreorder(int[] preorder, int minRange, int maxRange) {
        if (index >= preorder.length)
            return null;
        TreeNode root = null;
        if (preorder[index] >= minRange && preorder[index] <= maxRange) {
            root = new TreeNode(preorder[index]);
            index++;
            root.left = bstPreorder(preorder, minRange, root.val - 1);
            root.right = bstPreorder(preorder, root.val + 1, maxRange);
        }
        return root;
    }
}