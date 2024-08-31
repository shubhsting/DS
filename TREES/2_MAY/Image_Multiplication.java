// https://www.geeksforgeeks.org/problems/image-multiplication0627/1
class Solution {
    long MOD = 1000000007;

    public long imgMultiply(Node root) {
        long[] ans = new long[1];
        traverse(root.left, root.right, ans);
        ans[0] = ((ans[0] % MOD) + ((root.data % MOD) * (root.data % MOD))) % MOD;
        return ans[0];
    }

    public void traverse(Node root1, Node root2, long[] ans) {
        if (root1 == null || root2 == null)
            return;
        ans[0] = ((ans[0] % MOD) + ((root1.data % MOD) * (root2.data % MOD))) % MOD;
        traverse(root1.left, root2.right, ans);
        traverse(root1.right, root2.left, ans);
    }
}