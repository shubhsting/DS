import java.util.Arrays;
// https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
class Solution {
    public boolean findPair(int arr[], int n, int x) {

        Arrays.sort(arr);
        int start = 0;
        int end = 1;

        while (end < n && start < n) {
            if (start == end) {
                end++;
                continue;
            }
            if (arr[end] - arr[start] > x) {
                start++;
            } else if (arr[end] - arr[start] < x) {
                end++;
            } else {
                return true;
            }
        }
        return false;
    }
}
