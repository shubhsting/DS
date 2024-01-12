class Solution {
    // https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
    void segregate0and1(int[] arr, int n) {
        int oneStartIndex = 0;
        int currentIdx = 0;
        while (currentIdx < n) {
            if (arr[currentIdx] == 1) {
                currentIdx++;
            } else if (arr[currentIdx] == 0) {
                int temp = arr[oneStartIndex];
                arr[oneStartIndex] = arr[currentIdx];
                arr[currentIdx] = temp;
                oneStartIndex++;
                currentIdx++;
            }
        }
    }
}
