// https://leetcode.com/problems/longest-consecutive-sequence/
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int ele : nums) {
            int start = ele - map.getOrDefault(ele - 1, 0);
            int end = ele + map.getOrDefault(ele + 1, 0);
            if (map.containsKey(ele)) {
                continue;
            }
            // if(map.containsKey(ele + 1) && map.containsKey(ele - 1)) {
            // end = ele + map.get(ele + 1);
            // start = ele - map.get(ele - 1);
            // } else if(!map.containsKey(ele + 1) && map.containsKey(ele - 1)) {
            // start = ele - map.get(ele - 1);
            // end = ele;
            // } else if(map.containsKey(ele + 1) && !map.containsKey(ele - 1)) {
            // start = ele;
            // end = ele + map.get(ele + 1);
            // }
            // if there is duplicate

            map.putIfAbsent(ele, 0);
            int length = map.get(start) + map.get(end) + 1;
            map.put(start, length);
            map.put(end, length);
            ans = Math.max(ans, length);
        }
        return ans;
    }
}
