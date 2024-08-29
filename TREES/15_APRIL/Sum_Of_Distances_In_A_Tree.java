// https://leetcode.com/problems/sum-of-distances-in-tree/
class Solution {
    class Node {
        int val;
        int dist;

        Node(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n == 1)
            return new int[1];
        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int index = 0; index < n; index++)
            tree[index] = new ArrayList<>();
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            tree[parent].add(child);
            tree[child].add(parent);
        }
        int assumedRoot = edges[0][0];
        int[] noOfChilds = new int[n];
        boolean[] vis = new boolean[n];
        noofChildsDFS(tree, assumedRoot, noOfChilds, vis);

        int totalElements = noOfChilds[assumedRoot];
        int[] distances = new int[n];
        vis = new boolean[n];
        distances[assumedRoot] = distanceofAssumedRootFromEachNode(tree, assumedRoot, vis);
        vis = new boolean[n];
        populateDistancesForNode(tree, assumedRoot, noOfChilds, distances, totalElements, vis);
        return distances;
    }

    public int noofChildsDFS(ArrayList<Integer>[] tree, int root, int[] noOfChilds, boolean[] vis) {
        vis[root] = true;
        int ans = 0;
        for (Integer neighbour : tree[root]) {
            if (!vis[neighbour])
                ans += noofChildsDFS(tree, neighbour, noOfChilds, vis);
        }
        noOfChilds[root] = ans + 1;
        return noOfChilds[root];
    }

    public int distanceofAssumedRootFromEachNode(ArrayList<Integer>[] tree, int assumedRoot, boolean[] vis) {
        int ans = 0;
        LinkedList<Node> queue = new LinkedList<>();

        queue.addLast(new Node(assumedRoot, 0));

        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Node current = queue.removeFirst();
                vis[current.val] = true;
                ans += current.dist;
                for (int neighbour : tree[current.val]) {
                    if (!vis[neighbour])
                        queue.addLast(new Node(neighbour, current.dist + 1));
                }

            }
        }
        return ans;
    }

    public void populateDistancesForNode(ArrayList<Integer>[] tree, int node, int[] noOfChilds, int[] distances,
            int totalElements, boolean[] vis) {
        vis[node] = true;
        for (int neighbour : tree[node]) {
            if (!vis[neighbour]) {
                int nodesExceptNeighbourSubtree = totalElements - noOfChilds[neighbour];
                distances[neighbour] = distances[node] - noOfChilds[neighbour] + nodesExceptNeighbourSubtree;
                populateDistancesForNode(tree, neighbour, noOfChilds, distances, totalElements, vis);
            }

        }
    }
}