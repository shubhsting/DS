/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// https://leetcode.com/problems/closest-binary-search-tree-value-ii/
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current)
                    temp = temp.right;

                if (temp.right == null) {
                    temp.right = current;
                    current = current.left;
                } else {
                    handleElement(queue, current.val, target, k);
                    temp.right = null;
                    current = current.right;
                }
            } else {
                handleElement(queue, current.val, target, k);
                current = current.right;
            }
        }
        while (queue.size() != 0)
            ans.add(queue.removeFirst());
        return ans;
    }

    public void handleElement(LinkedList<Integer> queue, int current, double target, int k) {
        if (queue.size() < k)
            queue.addLast(current);
        else {
            if (Math.abs(current - target) <= Math.abs(queue.getLast() - target)) {
                queue.removeFirst();
                queue.addLast(current);
            } else if (Math.abs(current - target) < Math.abs(queue.getFirst() - target)) {
                queue.removeFirst();
                queue.addLast(current);
            }
        }
    }
}