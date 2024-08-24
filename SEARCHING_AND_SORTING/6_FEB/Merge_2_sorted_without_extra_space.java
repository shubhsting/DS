// https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
class Solution {
    // Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) {
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < n && idx2 < m) {
            if (arr1[idx1] >= arr2[idx2]) {
                long temp = arr1[idx1];
                arr1[idx1] = arr2[idx2];
                arr2[idx2] = temp;
                Arrays.sort(arr2);
            }
            idx1++;
        }
    }

    public static void insertionSort(int index, long[] arr) {
        for (int start = index + 1; start < arr.length; start++) {
            if (arr[start] < arr[start - 1]) {
                long temp = arr[start];
                arr[start] = arr[start - 1];
                arr[start - 1] = temp;
            }
        }
    }
}
