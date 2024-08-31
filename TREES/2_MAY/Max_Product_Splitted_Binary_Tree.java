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
// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
class Solution {
    long MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        HashMap<TreeNode, Long> map = new HashMap<>();
        long[] ans = new long[1];
        long sum = sumOfTree(root, map);
        maxProductOfSum(root, map, sum, ans);
        return (int) (ans[0] % MOD);
    }

    public long sumOfTree(TreeNode root, HashMap<TreeNode, Long> map) {
        if (root == null)
            return 0;
        long sum = 0;
        sum += sumOfTree(root.left, map);
        sum += sumOfTree(root.right, map);
        map.put(root, sum + root.val);
        return sum + root.val;

    }

    public void maxProductOfSum(TreeNode root, HashMap<TreeNode, Long> map, long totalSum, long[] ans) {
        if (root == null)
            return;
        if (root.left != null) {
            long sumAfterRemovingleftEdge = map.get(root.left) * (totalSum - map.get(root.left));
            ans[0] = Math.max(ans[0], sumAfterRemovingleftEdge);
            maxProductOfSum(root.left, map, totalSum, ans);
        }

        if (root.right != null) {
            long sumAfterRemovingRightEdge = map.get(root.right) * (totalSum - map.get(root.right));
            ans[0] = Math.max(ans[0], sumAfterRemovingRightEdge);
            maxProductOfSum(root.right, map, totalSum, ans);
        }

    }
}
