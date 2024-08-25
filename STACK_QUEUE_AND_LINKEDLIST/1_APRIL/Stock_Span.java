// https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
class Solution {
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = price.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && price[st.peek()] < price[i]) {
                int index = st.pop();
                price[index] = index - i;
            }
            st.push(i);
        }

        while (!st.isEmpty() && price[st.peek()] < 1000000000) {
            int index = st.pop();
            price[index] = index + 1;
        }
        return price;
    }
}