// https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
class Solution {

    public static long[] nextLargerElement(long[] arr, int n) {

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                int index = st.pop();
                arr[index] = arr[i];
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            arr[st.pop()] = -1;
        }
        return arr;
    }
}
