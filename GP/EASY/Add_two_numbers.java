// https://www.geeksforgeeks.org/problems/sum-of-two-numbers-without-using-arithmetic-operators/1
class Solution {
    int sum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}