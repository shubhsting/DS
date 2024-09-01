//https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Node last = treeToDoublyList2(root);
        return last.right;
    }

    public Node treeToDoublyList2(Node root) {
        if (root == null)
            return null;
        Node leftLastNode = treeToDoublyList2(root.left);
        Node rightLastNode = treeToDoublyList2(root.right);
        Node currentFirstNode = leftLastNode == null ? root : leftLastNode.right;
        Node currentLastNode = rightLastNode != null ? rightLastNode : root;
        if (leftLastNode != null) {
            Node leftFirstNode = leftLastNode.right;
            leftLastNode.right = root;
            root.left = leftLastNode;
            leftFirstNode.left = null;
        }
        if (rightLastNode != null) {
            Node rightFirstNode = rightLastNode.right;
            root.right = rightFirstNode;
            rightFirstNode.left = root;
            rightLastNode.right = null;
        }
        currentFirstNode.left = currentLastNode;
        currentLastNode.right = currentFirstNode;
        return currentLastNode;
    }
}