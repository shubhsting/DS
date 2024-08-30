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
// https://leetcode.com/problems/binary-tree-right-side-view/description/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null)
            return rightView;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (queue.size() != 0) {
            int size = queue.size();
            int currentLevelRightViewElement = 0;
            while (size-- > 0) {
                TreeNode current = queue.removeFirst();
                currentLevelRightViewElement = current.val;
                if (current.left != null)
                    queue.addLast(current.left);
                if (current.right != null)
                    queue.addLast(current.right);

            }
            rightView.add(currentLevelRightViewElement);
        }
        return rightView;

    }
}
