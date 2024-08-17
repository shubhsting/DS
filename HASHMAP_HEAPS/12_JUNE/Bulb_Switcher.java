// https://leetcode.com/problems/bulb-switcher/description/
class Solution {
    public int bulbSwitch(int n) {
        int index = 1;
        int count = 0;
        while (index * index <= n) {
            count++;
            index++;
        }
        return count;
    }
}
