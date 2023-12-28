import java.util.Arrays;
// https://www.geeksforgeeks.org/problems/minimum-swaps/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
class Solution {
    class Edge {
        int number;
        int index;

        Edge(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }

    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[]) {
        Edge[] numbers = new Edge[nums.length];
        for (int index = 0; index < nums.length; index++) {
            numbers[index] = new Edge(nums[index], index);
        }

        Arrays.sort(numbers, (Edge a, Edge b) -> {
            return a.number - b.number;
        });
        int ans = 0;
        boolean[] visited = new boolean[nums.length];

        for (int index = 0; index < numbers.length; index++) {

            if (!visited[index]) {

                int currentIndex = index;
                int noOfElementsInCurrentCycle = 0;
                while (!visited[currentIndex]) {
                    visited[currentIndex] = true;
                    Edge current = numbers[currentIndex];
                    noOfElementsInCurrentCycle++;
                    currentIndex = current.index;
                }
                ans += noOfElementsInCurrentCycle - 1;
            }
        }
        return ans;
    }
}