// https://www.geeksforgeeks.org/problems/check-arithmetic-progression1842/1
class Solution {
    // Function to check if the given array forms an arithmetic progression
    public boolean checkIsAP(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (num <= min) {
                secondMin = Math.min(min, secondMin);
                min = num;
            } else {
                secondMin = Math.min(num, secondMin);
            }
        }
        int start = min;
        int d = secondMin - min;
        for (int index = 1; index <= arr.length; index++) {
            int element = start + (index - 1) * d;
            if (!map.containsKey(element)) {
                return false;
            } else {
                map.put(element, map.get(element) - 1);
                if (map.get(element) == 0)
                    map.remove(element);
            }
        }
        return map.keySet().size() == 0;
    }
}
