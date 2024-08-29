/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

class Solution {
    public Node connect(Node root) {
        Node current = root;
        while (current != null && current.left != null) {
            Node temp = current;
            while (temp != null) {
                temp.left.next = temp.right;
                if (temp.next != null)
                    temp.right.next = temp.next.left;
                temp = temp.next;
            }
            current = current.left;
        }
        return root;
    }
}
