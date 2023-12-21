import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
	static class Node {
		private int node;
		private int weight;

		Node(final int node, final int weight) {
			this.node = node;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		while (tc-- > 0) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			ArrayList<Node>[] graph = new ArrayList[n + 1];
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < m; i++) {
				int start = scn.nextInt();
				int end = scn.nextInt();
				int weight = scn.nextInt();
				graph[start].add(new Node(end, weight));
			}
			int src = scn.nextInt();
			int end = scn.nextInt();

			int ans = dijkstraAlgo(graph, src, end);
			System.out.println(ans != -1 ? ans : "NO");
		}

	}

	public static int dijkstraAlgo(ArrayList<Node>[] graph, int start, int end) {
		boolean[] vis = new boolean[graph.length];
		PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> {
			return a.weight - b.weight;
		});
		pq.add(new Node(start, 0));
		while (pq.size() != 0) {
			int size = pq.size();
			while (size-- > 0) {
				Node temp = pq.remove();
				if (vis[temp.node] == true)
					continue;
				vis[temp.node] = true;
				if (temp.node == end) {
					return temp.weight;
				}
				for (Node neighbour : graph[temp.node]) {
					if (!vis[neighbour.node]) {
						pq.add(new Node(neighbour.node, neighbour.weight + temp.weight));
					}
				}
			}
		}
		return -1;
	}
}