// https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/1
class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(List<Integer> arr) {
        int ans = Integer.MIN_VALUE;
        for (int index = 1; index < arr.size(); index++) {
            ans = Math.max(ans, arr.get(index) + arr.get(index - 1));
        }
        return ans;
    }
}
