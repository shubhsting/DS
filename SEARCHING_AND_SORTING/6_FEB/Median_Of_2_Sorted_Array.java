// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalElements = nums1.length + nums2.length;
        int midElements = (totalElements + 1) / 2;
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = nums1.length + 1;
        int mid1 = 0;
        int mid2 = 0;
        while (low < high) {
            mid1 = low + (high - low) / 2;
            int noOfElementsIn1 = mid1;

            mid2 = midElements - noOfElementsIn1;
            if (mid1 < nums1.length && mid2 - 1 >= 0 && mid2 - 1 < nums2.length && mid1 >= 0
                    && nums1[mid1] < nums2[mid2 - 1]) {
                low = mid1;
            } else if (mid2 < nums2.length && mid1 - 1 >= 0 && mid2 >= 0 && mid1 - 1 < nums1.length
                    && nums1[mid1 - 1] > nums2[mid2]) {
                high = mid1;
            } else {
                break;
            }

        }
        // System.out.println("mid1: " + mid1 + " mid2: " + mid2);
        if (totalElements % 2 != 0) {
            int no1 = mid1 - 1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int no2 = mid2 - 1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            System.out.println(no1 + "  LL. " + no2);
            return 1.0 * Math.max(no1, no2);
        } else {
            int no1 = mid1 - 1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int no2 = mid2 - 1 >= 0 && mid2 - 1 < nums2.length ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int leftWindowMax = Math.max(no1, no2);
            int no3 = mid1 < nums1.length && mid1 >= 0 ? nums1[mid1] : Integer.MAX_VALUE;
            int no4 = mid2 >= 0 && mid2 < nums2.length ? nums2[mid2] : Integer.MAX_VALUE;
            int rightWindowMax = Math.min(no3, no4);
            return (1.0) * (rightWindowMax + leftWindowMax) / 2;
        }
    }
}
