// https://www.geeksforgeeks.org/problems/count-pairs-in-array-divisible-by-k/1
class Solution {
    public static long countKdivPairs(int arr[], int n, int k) {
        HashMap<Integer, Long> map = new HashMap<>();
        long ans = 0;

        for (int ele : arr) {
            int rem = ele % k;
            if (rem != 0) {
                ans += map.getOrDefault(k - rem, 0L);
            } else {
                ans += map.getOrDefault(0, 0L);
            }
            map.put(rem, map.getOrDefault(rem, 0L) + 1);
        }
        return ans;
    }
}
