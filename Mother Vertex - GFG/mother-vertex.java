//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>graph)
    {
       boolean[] visited = new boolean[V];
       Stack<Integer> stack = new Stack<>();
       for(int index = 0; index<V; index++) {
           if(!visited[index]) {
               DFS(graph, visited, index, stack);
           }
       }
       visited = new boolean[V];
       Integer motherVertex = stack.pop();
       DFS(graph, visited, motherVertex, null);
       
       for(boolean isNodeVisited: visited) {
           if(!isNodeVisited) {return -1;}
       }
       return motherVertex;
    }
     public void DFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int current, Stack stack) {
        visited[current] = true;
        for (Integer neighbour : graph.get(current)) {
            if (!visited[neighbour]) {
                DFS(graph, visited, neighbour, stack);
            }
        }
        if (stack != null) {
            stack.push(current);
        }
    } 
}