import java.util.ArrayList;
import java.util.LinkedList;
// https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int index = 0; index < n; index++) {
            graph[index] = new ArrayList<>();
        }
        int[] inorder = new int[n];
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            inorder[edge[1]]++;
        }
        int[][] colorStore = new int[n][26];
        char[] color = colors.toCharArray();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int index = 0; index < n; index++) {
            if (inorder[index] == 0) {
                queue.addLast(index);
                colorStore[index][color[index] - 'a'] += 1;
            }
        }
        int ans = Integer.MIN_VALUE;
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                int current = queue.removeFirst();
                for (int count : colorStore[current]) {
                    ans = Math.max(ans, count);
                }
                for (Integer neighbour : graph[current]) {
                    for (int index = 0; index < 26; index++) {
                        colorStore[neighbour][index] = Math.max(colorStore[neighbour][index],
                                colorStore[current][index]);
                    }
                    inorder[neighbour] = inorder[neighbour] - 1;
                    int colorIndex = color[neighbour] - 'a';

                    colorStore[neighbour][colorIndex] = Math.max(colorStore[neighbour][colorIndex],
                            colorStore[current][colorIndex] + 1);
                    if (inorder[neighbour] == 0) {
                        queue.addLast(neighbour);
                    }
                }
            }
        }
        for (int in : inorder) {
            if (in != 0) {
                return -1;
            }
        }
        return ans;
    }
}
