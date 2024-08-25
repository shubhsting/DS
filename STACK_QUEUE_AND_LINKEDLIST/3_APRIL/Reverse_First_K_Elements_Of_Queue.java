// https://www.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1
class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();
        int temp = q.size() - k;
        while (k-- > 0) {
            st.push(q.remove());
        }

        while (!st.isEmpty()) {
            q.add(st.pop());
        }

        while (temp-- > 0) {
            q.add(q.remove());
        }
        return q;
    }
}
