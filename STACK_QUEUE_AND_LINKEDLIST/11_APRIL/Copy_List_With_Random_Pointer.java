/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// https://leetcode.com/problems/copy-list-with-random-pointer/
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val, null, null));
            current = current.next;
        }
        current = head;
        while (current != null) {
            Node newNode = map.get(current);
            newNode.next = map.get(current.next);
            newNode.random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
}

// approach2 without space

/*
 * // Definition for a Node.
 * class Node {
 * int val;
 * Node next;
 * Node random;
 * 
 * public Node(int val) {
 * this.val = val;
 * this.next = null;
 * this.random = null;
 * }
 * }
 */

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val, null, null);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        current = head;
        Node newHead = current.next;
        while (current != null) {
            Node newNode = current.next;
            if (current.random != null)
                newNode.random = current.random.next;
            current = current.next.next;
        }
        current = head;
        while (current != null && current.next != null) {
            Node newNode = current.next;
            current.next = newNode.next;
            if (current.next != null)
                newNode.next = current.next.next;
            current = current.next;
        }
        return newHead;
    }
}