import java.util.Arrays;
// https://www.geeksforgeeks.org/problems/key-pair5616/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        Arrays.sort(arr);
        int start = 0; 
        int end = arr.length - 1;
        
        while(start<end) {
            if(arr[start] + arr[end]>x) {
                end--;
            } else if(arr[start] + arr[end]<x) {
                start++;
            } else {
                return true;
            }
        }
        return false;
    }
}