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
// https://leetcode.com/problems/binary-tree-coloring-game/
class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int[] noOfNodes = new int[n + 1];
        TreeNode[] xNode = new TreeNode[1];
        totalElements(root, noOfNodes, xNode, x);
        boolean ans = false;
        ans = ans || n - noOfNodes[x] > noOfNodes[x];
        if (xNode[0].left != null)
            ans = ans || noOfNodes[xNode[0].left.val] > n - noOfNodes[xNode[0].left.val];
        if (xNode[0].right != null)
            ans = ans || noOfNodes[xNode[0].right.val] > n - noOfNodes[xNode[0].right.val];
        return ans;
    }

    public int totalElements(TreeNode root, int[] nodes, TreeNode[] xNode, int x) {
        if (root == null)
            return 0;
        if (root.val == x)
            xNode[0] = root;
        return nodes[root.val] = totalElements(root.left, nodes, xNode, x) + totalElements(root.right, nodes, xNode, x)
                + 1;
    }
}
