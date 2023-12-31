import java.util.HashMap;
// https://www.codingninjas.com/studio/problems/minimum-swaps-to-make-identical-array_3843992?leftPanelTabValue=PROBLEM
class Solution {
    public static int minimumSwaps(int n, int[] A, int[] B) {
        HashMap<Integer, Integer> sourceArrayIndices = new HashMap<>();
        for (int index = 0; index < n; index++) {
            sourceArrayIndices.put(A[index], index);
        }

        int ans = 0;
        boolean[] visited = new boolean[n];
        for (int index = 0; index < n; index++) {
            if (A[index] == B[index]) {
                visited[index] = true;
                continue;
            }
            if (!visited[index]) {
                int cycleSize = 0;
                int currentIndex = index;

                while (!visited[currentIndex]) {
                    visited[currentIndex] = true;
                    currentIndex = sourceArrayIndices.get(B[currentIndex]);
                    cycleSize++;
                }
                ans += (cycleSize - 1);
            }

        }
        return ans;
    }
}
