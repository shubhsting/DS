// https://www.geeksforgeeks.org/problems/reverse-level-order-traversal/1
class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.addLast(node);
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Node current = queue.removeFirst();
                ans.add(current.data);
                if (current.right != null)
                    queue.addLast(current.right);
                if (current.left != null)
                    queue.addLast(current.left);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
