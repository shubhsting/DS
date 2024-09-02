// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderIndex = new HashMap<>();
        for (int index = 0; index < inorder.length; index++) {
            inorderIndex.put(inorder[index], index);
        }
        return build(preorder, inorder, inorderIndex, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] pre, int[] in, HashMap<Integer, Integer> inorderIndex, int preStart, int preEnd,
            int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        int rootNode = pre[preStart];

        int idx = inorderIndex.get(rootNode);
        int noOfElements = idx - inStart;
        TreeNode root = new TreeNode(rootNode);
        root.left = build(pre, in, inorderIndex, preStart + 1, preStart + noOfElements, inStart, idx - 1);
        root.right = build(pre, in, inorderIndex, preStart + noOfElements + 1, preEnd, idx + 1, inEnd);
        return root;
    }
}