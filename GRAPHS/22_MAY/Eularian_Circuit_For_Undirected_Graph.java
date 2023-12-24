import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/euler-circuit-in-a-directed-graph/1
class Solution {
    public boolean isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj) {
        if (V == 1)
            return true;
        for (int i = 0; i < V; i++)
            if (adj.get(i).size() % 2 != 0)
                return false;
        return true;
    }
}