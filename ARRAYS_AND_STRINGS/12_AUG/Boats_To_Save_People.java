import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;
        int ans = 0;
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                ans += 1;
                start++;
                end--;
            } else {
                ans += 1;
                end--;
            }
        }
        return ans;
    }
}
