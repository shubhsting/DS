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
//https://leetcode.com/problems/split-linked-list-in-parts/description/
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];
        if (head == null)
            return arr;
        ListNode current = head;
        int size = 1;
        while (current.next != null) {
            size++;
            current = current.next;
        }

        int windowSize = size / k;
        int extraElements = size % k;
        int currentWindowSize = 0;
        int currentIndex = 0;
        ListNode prev = null;
        current = head;
        // System.out.println("size" + size +"->"+extraElements);
        while (current != null) {
            arr[currentIndex] = current;
            // System.out.println("current.value" + current.val + "---?" + windowSize);
            currentIndex++;
            while (current != null && currentWindowSize < windowSize) {
                prev = current;
                current = current.next;
                currentWindowSize++;
            }
            // System.out.println("current.value" + current.val + ":" + extraElements);
            if (extraElements > 0 && current != null) {
                prev = current;
                current = current.next;
                extraElements--;
            }

            prev.next = null;

            currentWindowSize = 0;
        }
        return arr;
    }
}