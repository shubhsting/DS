/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
class Solution {
    ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        int size = size(head);
        current = head;
        return convert(size);
    }

    public TreeNode convert(int size) {
        if (size <= 0)
            return null;
        TreeNode left = convert(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        root.left = left;
        root.right = convert(size - size / 2 - 1);
        return root;
    }

    public int size(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size += 1;
            current = current.next;
        }
        return size;
    }
}
