// https://leetcode.com/problems/intersection-of-two-arrays/description
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int num : nums1)
            seen.put(num, 0);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : nums2) {
            if (seen.containsKey(num) && seen.get(num) == 0) {
                ans.add(num);
                seen.put(num, 1);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

}