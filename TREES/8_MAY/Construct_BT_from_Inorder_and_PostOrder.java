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
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorderIndex = new HashMap<>();
        for (int index = 0; index < inorder.length; index++) {
            inorderIndex.put(inorder[index], index);
        }
        return build(inorder, postorder, inorderIndex, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int[] in, int[] post, HashMap<Integer, Integer> inorderIndex, int inStart, int inEnd,
            int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;
        int rootNode = post[postEnd];
        int idx = inorderIndex.get(rootNode);
        int noOfElements = idx - inStart;
        TreeNode root = new TreeNode(rootNode);
        root.left = build(in, post, inorderIndex, inStart, idx - 1, postStart, postStart + noOfElements - 1);
        root.right = build(in, post, inorderIndex, idx + 1, inEnd, postStart + noOfElements, postEnd - 1);
        return root;
    }
}
