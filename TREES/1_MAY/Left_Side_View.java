// https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
class Tree {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> leftView = new ArrayList<>();
        if (root == null)
            return leftView;
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while (queue.size() != 0) {
            int size = queue.size();
            int currentLevelRightViewElement = 0;
            while (size-- > 0) {
                Node current = queue.removeFirst();
                currentLevelRightViewElement = current.data;
                if (current.right != null)
                    queue.addLast(current.right);
                if (current.left != null)
                    queue.addLast(current.left);
            }
            leftView.add(currentLevelRightViewElement);
        }
        return leftView;
    }
}