package GRAPHS.MISC;

import java.util.ArrayList;
import java.util.Arrays;
// https://www.codingninjas.com/studio/problems/longest-path-in-directed-graph_1172157?leftPanelTabValue=SUBMISSION
class Solution {
    static class Edge {
        private int end;
        private int weight;

        Edge(final int end, final int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static ArrayList<Integer> findMaxDistances(int N, int src, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int index = 0; index < N; index++) {
            graph[index] = new ArrayList<>();
        }
        for (ArrayList<Integer> edge : edges) {
            int start = edge.get(0);
            int end = edge.get(1);
            int weight = edge.get(2);
            graph[start].add(new Edge(end, weight));
        }
        int[] distance = new int[N];
        Arrays.fill(distance, -1);
        DFS(graph, distance, new boolean[N], src, 0);
        ArrayList<Integer> op = new ArrayList<>();
        for (Integer p : distance) {
            op.add(p);
        }
        return op;
    }

    public static void DFS(ArrayList<Edge>[] graph, int[] distance, boolean[] vis, int src, int currentDistance) {
        distance[src] = Math.max(distance[src], currentDistance);
        if (vis[src]) {
            return;
        }
        vis[src] = true;
        for (Edge neighbours : graph[src]) {
            DFS(graph, distance, vis, neighbours.end, currentDistance + neighbours.weight);
        }
        vis[src] = false;
    }
}


class SolutionFinal {
    	static class Edge {
		private int end;
		private int weight;

		Edge(final int end, final int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
    public static ArrayList<Integer> findMaxDistances(int N, int src, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<Edge>[] graph = new ArrayList[N];
        int[] inorder = new int[N];
        for(int index = 0; index<N; index++) {
            graph[index] = new ArrayList<>();
        }
        for(ArrayList<Integer> edge: edges) {
            int start = edge.get(0);
            int end = edge.get(1);
            int weight = edge.get(2);
            graph[start].add(new Edge(end, weight));
            inorder[end]++;
        }
        int[] distance = new  int[N];
        Arrays.fill(distance, -1);
        LinkedList<Edge> queue = new LinkedList<>();
        for(int index = 0; index<N; index++) {
            if(inorder[index] == 0 && index!=src) {
                queue.addLast(new Edge(index, -1));
            } else if(inorder[index] == 0 && index==src) {
                queue.addLast(new Edge(index, 0));
            }
        }
        
        distance[src] = 0;
        while(queue.size()!=0) {
            int size = queue.size();
            while(size-->0) {
                Edge current = queue.removeFirst();
                for(Edge neighbour: graph[current.end]) {
                    if(distance[current.end]!=-1) {
                        distance[neighbour.end] = Math.max(distance[neighbour.end], distance[current.end] + neighbour.weight);
                    }
                    inorder[neighbour.end]--;
                    if(inorder[neighbour.end] == 0) {
                        queue.addLast(neighbour);
                    }
                }
            }
        }


        ArrayList<Integer> op = new ArrayList<>();
        for(Integer p: distance) {
            op.add(p);
        }
        return op;
    }

}