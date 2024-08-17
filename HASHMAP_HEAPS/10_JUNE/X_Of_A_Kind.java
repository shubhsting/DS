// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int count : map.values()) {
            ans = gcd(ans, count);
        }
        return ans > 1;
    }

    public int gcd(int a, int b) {
        return a > 0 ? gcd(b % a, a) : b;
    }
}
