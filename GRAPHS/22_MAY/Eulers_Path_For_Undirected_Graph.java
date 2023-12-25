import java.util.ArrayList;
import java.util.HashSet;
// https://www.codingninjas.com/studio/problems/euler-path_1214547?leftPanelTabValue=PROBLEM
class Solution {
    public static ArrayList<Integer> printEulerPath(int n, ArrayList<ArrayList<Integer>> edgeList) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int index = 0; index < n; index++) {
            graph[index] = new ArrayList<>();
        }
        int[] degree = new int[n];

        for (ArrayList<Integer> edge : edgeList) {
            int start = edge.get(0);
            int end = edge.get(1);
            degree[start]++;
            graph[start].add(end);
            graph[end].add(start);
            degree[end]++;
        }
        int oddDegree = 0;
        int oddDegreeEntry = Integer.MAX_VALUE;

        for (int index = 0; index < n; index++) {
            if (degree[index] % 2 != 0) {
                oddDegree++;
                oddDegreeEntry = index;
            }
        }
        boolean isEulerionPathPresent = oddDegree == 0 || oddDegree == 2;
        ArrayList<Integer> answer = new ArrayList<>();
        if (!isEulerionPathPresent) {
            answer.add(-1);
            return answer;
        }
        HashSet<String> visited = new HashSet<>();
        if (oddDegree > 0) {
            eularianPath(graph, visited, oddDegreeEntry, answer);
        } else {
            eularianPath(graph, visited, 0, answer);
        }
        for (ArrayList<Integer> edge : edgeList) {
            int start = edge.get(0);
            int end = edge.get(1);
            if (!visited.contains(start + "," + end) && !visited.contains(end + "," + start)) {
                answer = new ArrayList<>();
                answer.add(-1);
                return answer;
            }
        }
        return answer;
    }

    public static void eularianPath(ArrayList<Integer>[] graph, HashSet<String> visited, int src,
            ArrayList<Integer> ans) {

        for (Integer neighbour : graph[src]) {
            if (!visited.contains(src + "," + neighbour)) {
                visited.add(src + "," + neighbour);
                visited.add(neighbour + "," + src);
                eularianPath(graph, visited, neighbour, ans);
            }
        }
        ans.add(0, src);
    }
}