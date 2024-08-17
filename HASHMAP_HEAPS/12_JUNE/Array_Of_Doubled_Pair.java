//https://leetcode.com/problems/array-of-doubled-pairs/
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        for (int ele : arr) {
            if (map.containsKey(ele) && map.containsKey(2 * ele)) {
                map.put(2 * ele, map.get(2 * ele) - 1);
                map.put(ele, map.get(ele) - 1);
                if (map.get(ele) == 0)
                    map.remove(ele);
                if (ele != 2 * ele && map.get(2 * ele) == 0)
                    map.remove(2 * ele);

            }

        }
        return map.keySet().size() == 0;
    }
}
