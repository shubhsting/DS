//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> graph)
    {
       Stack<Integer> topologicalOrder = new Stack<>();
       ArrayList<ArrayList<Integer>> invertedGraph = new ArrayList<>();
       boolean[] visited = new boolean[V];
       
       for(int index = 0; index<V; index++) {
           if(!visited[index]) {
                DFS(graph, visited, index, topologicalOrder);
           }
           invertedGraph.add(new ArrayList<>());
       }
       
       for(int index = 0; index<V; index++) {
           for(Integer neighbour: graph.get(index)) {
               invertedGraph.get(neighbour).add(index);
           }
       }
       
       int count = 0;
       visited = new boolean[V];
       
       while(!topologicalOrder.isEmpty()) {
           int element = topologicalOrder.pop();
           if(!visited[element]) {
               count = count+1;
                DFS(invertedGraph, visited, element, null);
           }
       }
       return count;
    }
    
    public void DFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int current, Stack stack) {
        visited[current] = true;
        for(Integer neighbour: graph.get(current)) {
            if(!visited[neighbour]) {
                DFS(graph, visited, neighbour, stack);
            }
        }
        if(stack!=null) {
            stack.push(current);
        }
    }
    
}
