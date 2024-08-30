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
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
class Solution {
    class Pair {
        TreeNode node;
        int row;
        int column;

        Pair(TreeNode node, int row, int column) {
            this.node = node;
            this.row = row;
            this.column = column;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Pair> queue = new LinkedList<>();
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        queue.addLast(new Pair(root, 0, 0));
        int row = 0;
        int min = 0;
        int max = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            ArrayList<Pair> temp = new ArrayList<>();
            while (size-- > 0) {
                Pair current = queue.removeFirst();
                map.putIfAbsent(current.column, new ArrayList<>());
                map.get(current.column).add(current);
                min = Math.min(min, current.column);
                max = Math.max(max, current.column);
                if (current.node.left != null)
                    queue.addLast(new Pair(current.node.left, current.row + 1, current.column - 1));
                if (current.node.right != null)
                    queue.addLast(new Pair(current.node.right, current.row + 1, current.column + 1));
            }
        }
        for (int index = min; index <= max; index++) {
            ArrayList<Pair> list = map.get(index);
            Collections.sort(list, (Pair a, Pair b) -> {
                if (a.row == b.row)
                    return a.node.val - b.node.val;
                return a.row - b.row;
            });
            List<Integer> temp = new ArrayList<>();
            for (Pair t : list)
                temp.add(t.node.val);
            ans.add(temp);
        }
        return ans;
    }
}
