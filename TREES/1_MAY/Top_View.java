//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
class Solution {
    static class ViewNode {
        Node node;
        int level;

        ViewNode(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> topView = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        LinkedList<ViewNode> queue = new LinkedList<>();
        queue.addLast(new ViewNode(root, 0));
        HashMap<Integer, Integer> levelToNodeMap = new HashMap<>();
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                ViewNode current = queue.removeFirst();
                if (!levelToNodeMap.containsKey(current.level)) {
                    levelToNodeMap.put(current.level, current.node.data);
                    min = Math.min(min, current.level);
                    max = Math.max(max, current.level);
                }
                if (current.node.left != null)
                    queue.addLast(new ViewNode(current.node.left, current.level - 1));
                if (current.node.right != null)
                    queue.addLast(new ViewNode(current.node.right, current.level + 1));
            }
        }
        for (int index = min; index <= max; index++)
            topView.add(levelToNodeMap.get(index));
        return topView;
    }
}
