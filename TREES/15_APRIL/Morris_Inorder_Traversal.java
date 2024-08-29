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
//https://leetcode.com/problems/binary-tree-inorder-traversal/description/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current)
                    temp = temp.right;

                if (temp.right == current) {
                    ans.add(current.val);
                    temp.right = null;
                    current = current.right;
                } else {
                    temp.right = current;
                    current = current.left;
                }

            } else {
                ans.add(current.val);
                current = current.right;
            }
        }
        return ans;
    }
}
