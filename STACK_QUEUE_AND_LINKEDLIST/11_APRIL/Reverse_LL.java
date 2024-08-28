/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// https://leetcode.com/problems/reverse-linked-list/description/
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode newCurrent = current.next;
            current.next = prev;
            prev = current;
            current = newCurrent;

        }
        return prev;
    }
}