import java.util.ArrayList;
import java.util.LinkedList;
// https://leetcode.com/problems/course-schedule-ii/
// Kahns Algo
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] ans = new int[numCourses];
        int[] inorder = new int[numCourses];
        for (int index = 0; index < numCourses; index++) {
            graph[index] = new ArrayList<>();
        }
        for (int index = 0; index < prerequisites.length; index++) {
            int start = prerequisites[index][1];
            int end = prerequisites[index][0];
            graph[start].add(end);
            inorder[end] = inorder[end] + 1;
        }
        for (int index = 0; index < numCourses; index++) {
            if (inorder[index] == 0) {
                queue.addLast(index);
            }
        }
        int currentIndex = 0;

        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                int current = queue.removeFirst();
                ans[currentIndex] = current;
                currentIndex++;
                for (Integer neighbour : graph[current]) {
                    inorder[neighbour]--;
                    if (inorder[neighbour] == 0) {
                        queue.addLast(neighbour);
                    }
                }
            }
        }
        for (int index = 0; index < numCourses; index++) {
            if (inorder[index] != 0) {
                return new int[0];
            }
        }
        return ans;
    }
}