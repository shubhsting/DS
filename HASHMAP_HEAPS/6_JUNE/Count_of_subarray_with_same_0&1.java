//https://www.geeksforgeeks.org/problems/equal-0-1-and-23208/1
class Solution {
    // Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {

        int prefix_count_1 = 0;
        int prefix_count_0 = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                prefix_count_0++;
            } else {
                prefix_count_1++;
            }
            int diff = prefix_count_1 - prefix_count_0;
            map.putIfAbsent(diff, 0);
            ans += map.get(diff);
            map.put(diff, map.get(diff) + 1);
        }
        return ans;
    }
}
