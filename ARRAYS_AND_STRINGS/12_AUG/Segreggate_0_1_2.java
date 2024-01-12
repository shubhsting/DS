// https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
class Solution {
    public static void sort012(int arr[], int n) {
        int oneStartIndex = 0;
        int twoStartIndex = n - 1;
        int currentIdx = 0;
        while (currentIdx <= twoStartIndex) {
            if (arr[currentIdx] == 1) {
                currentIdx++;
            } else if (arr[currentIdx] == 2) {
                // swap 2 start index with currentIdxx
                int temp = arr[currentIdx];
                arr[currentIdx] = arr[twoStartIndex];
                arr[twoStartIndex] = temp;
                twoStartIndex--;

            } else if (arr[currentIdx] == 0) {
                int temp = arr[currentIdx];
                arr[currentIdx] = arr[oneStartIndex];
                arr[oneStartIndex] = temp;
                oneStartIndex++;
                currentIdx++;
            }
        }
    }
}
