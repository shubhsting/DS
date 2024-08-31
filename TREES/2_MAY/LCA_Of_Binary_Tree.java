// https://www.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
class Solution {
    // Function to return the lowest common ancestor in a Binary Tree.
    Node lca(Node root, int p, int q) {
        if (root == null || root.data == p || root.data == q)
            return root;
        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);
        if (left != null && right != null)
            return root;
        else if (left != null || right != null)
            return left == null ? right : left;
        return null;
    }
}
