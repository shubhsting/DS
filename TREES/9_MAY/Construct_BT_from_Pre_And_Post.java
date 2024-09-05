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
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < postorder.length; index++)
            map.put(postorder[index], index);

        return construct(preorder, postorder, map, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode construct(int[] pre, int[] post, HashMap<Integer, Integer> map, int preStart, int preEnd,
            int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd || preStart + 1 >= pre.length)
            return root;
        int postIndex = map.get(pre[preStart + 1]);
        int noOfElementsInLeft = postIndex - postStart + 1;

        root.left = construct(pre, post, map, preStart + 1, preStart + noOfElementsInLeft, postStart, postIndex);
        root.right = construct(pre, post, map, preStart + noOfElementsInLeft + 1, preEnd, postIndex + 1, postEnd - 1);
        return root;
    }
}