//https://leetcode.com/problems/min-stack/description/
class MinStack {
    Stack<Integer> st;
    int currentMin;

    public MinStack() {
        st = new Stack<>();
        currentMin = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(0);
            currentMin = val;
        } else {
            st.push(val - currentMin);
            currentMin = Math.min(currentMin, val);
        }
    }

    public void pop() {
        if (st.peek() < 0) {
            int num = st.pop();
            // currentMin = num - previousMin
            // previousMin = num - currentMin
            currentMin = currentMin - num;
        } else {
            st.pop();
        }
    }

    public int top() {
        // original_element - min = current_element;
        // original_element = current_element + min;
        if (st.peek() < 0)
            return currentMin;
        return st.peek() + currentMin;

    }

    public int getMin() {
        return currentMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 // approach 2
class MinStack {
    Node head;

    public MinStack() {
        head = null;
    }

    public void push(int val) {
        if (head == null)
            head = new Node(val, val, null);
        else
            head = new Node(val, Math.min(val, head.min), head);
    }

    public void pop() {
        Node temp = head.next;
        head.next = null;
        head = temp;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */