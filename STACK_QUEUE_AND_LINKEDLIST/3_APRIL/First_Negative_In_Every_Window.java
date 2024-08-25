// https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
class Compute {

    public long[] printFirstNegativeInteger(long arr[], int N, int K) {
        long[] ans = new long[N - K + 1];
        int negativeIndex = N;
        int index = N - 1;
        while (index >= 0) {
            negativeIndex = arr[index] < 0 ? index : negativeIndex;
            if (index + K <= N) {
                // System.out.println("hello"+index);
                ans[index] = negativeIndex < index + K && negativeIndex < N ? arr[negativeIndex] : 0;
            }
            index--;
        }
        return ans;
    }
}
