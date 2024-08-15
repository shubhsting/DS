// https://www.geeksforgeeks.org/problems/sub-array-sum-divisible-by-k2617/1
class Solution {
    long subCount(long arr[], int n, int k) {
        long prefix_ans = 0;
        long ans = 0;
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 0L + 1);
        for (int index = 0; index < arr.length; index++) {
            prefix_ans = prefix_ans + arr[index];
            long val = prefix_ans % k;
            if (val < 0) {
                val += k;
            }
            if (map.containsKey(val)) {
                ans += map.get(val);
            }
            map.putIfAbsent(val, 0L);
            map.put(val, map.get(val) + 1);
        }
        return ans;
    }
}
