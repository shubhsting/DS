// https://leetcode.com/problems/binary-tree-cameras/description/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 // camera installed -> 2
 // under camera attention -> 1
 // none -> 0
 //nothing(null nodes) -> -1
 class Solution {
    public int minCameraCover(TreeNode root) {
        int[] ans = new int[1];
        int rootNodeStatus = minCameraCover2(root, ans);
        return rootNodeStatus == 0 ? ans[0] + 1: ans[0];
    }

    public int minCameraCover2(TreeNode root, int[] ans) {
        if(root == null) return -1;
        if(root.left == null && root.right == null) return 0;
        int left = minCameraCover2(root.left, ans);
        int right = minCameraCover2(root.right, ans);
        if(left == 0 || right == 0) {
            ans[0]++;
            return 2;
        } else if(left == 2 || right == 2) return 1;
        return 0;
    }
}