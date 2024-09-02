// https://www.geeksforgeeks.org/problems/merge-two-bst-s/1
class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public List<Integer> merge(Node root1, Node root2) {
        Node one = treeToDoublyList2(root1);
        Node two = treeToDoublyList2(root2);
        Node start1 = one.right;
        Node start2 = two.right;
        one.right = null;
        two.right = null;
        List<Integer> ans = new ArrayList<>();
        merge2DLL(start1, start2, ans);
        return ans;
    }

    public Node treeToDoublyList2(Node root) {
        if (root == null)
            return null;
        Node leftLastNode = treeToDoublyList2(root.left);
        Node rightLastNode = treeToDoublyList2(root.right);
        Node currentFirstNode = leftLastNode == null ? root : leftLastNode.right;
        Node currentLastNode = rightLastNode != null ? rightLastNode : root;
        if (leftLastNode != null) {
            Node leftFirstNode = leftLastNode.right;
            leftLastNode.right = root;
            root.left = leftLastNode;
            leftFirstNode.left = null;
        }
        if (rightLastNode != null) {
            Node rightFirstNode = rightLastNode.right;
            root.right = rightFirstNode;
            rightFirstNode.left = root;
            rightLastNode.right = null;
        }
        currentFirstNode.left = currentLastNode;
        currentLastNode.right = currentFirstNode;
        return currentLastNode;
    }

    public void merge2DLL(Node a, Node b, List<Integer> ans) {
        Node one = a;
        Node two = b;
        while (one != null && two != null) {
            if (one.data <= two.data) {
                ans.add(one.data);
                one = one.right;
            } else {
                ans.add(two.data);
                two = two.right;
            }
        }
        if (two == null) {
            while (one != null) {
                ans.add(one.data);
                one = one.right;
            }
        }
        if (one == null) {
            while (two != null) {
                ans.add(two.data);
                two = two.right;
            }
        }
    }

}
