// https://leetcode.com/problems/lru-cache/description/
class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node previous;

        Node(int key, int value, Node previous, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    HashMap<Integer, Node> keyReferences;
    Node head;
    Node tail;
    int cap;

    public LRUCache(int capacity) {
        head = new Node(-1, -1, null, null);
        tail = new Node(-1, -1, null, null);
        head.next = tail;
        tail.previous = head;
        cap = capacity;
        keyReferences = new HashMap<>();
    }

    public int get(int key) {
        // System.out.println( "ye rha head" + head.next.key +" -> "
        // +keyReferences.keySet());
        if (!keyReferences.containsKey(key))
            return -1;
        int value = keyReferences.get(key).value;
        remove(keyReferences.get(key));
        put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (keyReferences.containsKey(key)) {
            remove(keyReferences.get(key));
            put(key, value);
            return;
        }
        if (keyReferences.keySet().size() >= cap)
            remove(head.next);

        Node node = new Node(key, value, null, null);
        keyReferences.put(key, node);
        Node secondLast = tail.previous;
        tail.previous = node;
        node.next = tail;
        node.previous = secondLast;
        secondLast.next = node;
    }

    private void remove(Node toBeRemoved) {
        Node previousNode = toBeRemoved.previous;
        Node nextNode = toBeRemoved.next;
        previousNode.next = nextNode;
        nextNode.previous = previousNode;
        toBeRemoved.next = null;
        toBeRemoved.previous = null;
        keyReferences.remove(toBeRemoved.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */