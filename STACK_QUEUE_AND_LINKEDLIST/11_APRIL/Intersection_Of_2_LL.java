/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
//https://leetcode.com/problems/intersection-of-two-linked-lists/description/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode current = headA;
        int sizeA = 0;
        int sizeB = 0;
        while (current.next != null) {
            sizeA++;
            current = current.next;
        }
        current = headB;
        while (current.next != null) {
            sizeB++;
            current = current.next;
        }

        current = sizeA > sizeB ? headA : headB;
        ListNode current2 = sizeA > sizeB ? headB : headA;
        int skip = 0;
        while (current.next != null && skip < Math.abs(sizeA - sizeB)) {
            skip++;
            current = current.next;
        }
        while (current != current2 && current.next != null && current2.next != null) {
            current = current.next;
            current2 = current2.next;
        }
        return current == current2 ? current : null;
    }
}