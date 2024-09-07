// https://www.geeksforgeeks.org/problems/find-first-set-bit-1587115620/1
//using left shift
class Solution {
    // Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n) {
        if (n == 0)
            return 0;

        int index = 1;
        int num = 1;
        while ((n & num) == 0) {
            num = num << 1;
            index++;
        }
        return index;
    }
}

// using right shift
class Solution {
    // Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n) {

        // Position variable initialize
        // with 1 m variable is used to
        // check the set bit
        if (n == 0)
            return 0;
        int position = 1;
        int m = 1;

        while ((n & 1) == 0) {

            // left shift
            n = n >>> 1;
            position++;
        }
        return position;
    }
}