
// https://leetcode.com/problems/the-skyline-problem/description/
class Solution {
    class Edge {
        int coordinate;
        int height;

        Edge(int coordinate, int height) {
            this.coordinate = coordinate;
            this.height = height;
        }

    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((Edge a, Edge b) -> {
            if (a.coordinate == b.coordinate) {
                return b.height - a.height;
            }
            return a.coordinate - b.coordinate;
        });
        for (int[] building : buildings) {
            pq.add(new Edge(building[0], building[2]));
            pq.add(new Edge(building[1], -building[2]));
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((Integer a, Integer b) -> {
            return b - a;
        });
        int previousHeight = 0;
        queue.add(0);
        List<List<Integer>> ans = new ArrayList<>();
        while (pq.size() != 0) {
            Edge current = pq.remove();

            if (current.height > 0) {
                queue.add(current.height);
            } else {
                queue.remove(-current.height);
            }

            if (previousHeight != queue.peek()) {
                previousHeight = queue.peek();
                List<Integer> temp = new ArrayList<>();
                temp.add(current.coordinate);
                temp.add(queue.peek());
                ans.add(temp);
            }
        }
        return ans;

    }
}
