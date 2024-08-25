//https://www.geeksforgeeks.org/problems/maximum-difference-1587115620/1
class Solution {
    public int findMaxDiff(int[] arr) {
        int[] right = rightSmallerElement(arr.clone());
        int[] left = leftSmallerElement(arr);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, Math.abs(left[i] - right[i]));
        }
        return ans;
    }

    public static int[] rightSmallerElement(int[] arr) {

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int index = st.pop();
                arr[index] = arr[i];
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            arr[st.pop()] = 0;
        }
        return arr;
    }

    public static int[] leftSmallerElement(int[] arr) {

        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int index = st.pop();
                arr[index] = arr[i];
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            arr[st.pop()] = 0;
        }
        return arr;
    }
}

// approach 2:
class Solution {
    public int findMaxDiff(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans = Integer.MIN_VALUE;
        for (int index = 0; index < arr.length; index++) {
            while (!st.isEmpty() && arr[index] < arr[st.peek()]) {
                int op = st.pop();
                // System.out.println("popped" + st.pop());
                int leftMin = !st.isEmpty() ? arr[st.peek()] : 0;

                ans = Math.max(ans, Math.abs(arr[index] - leftMin));
                // if(op == 21 || op == 20 || op == 22) {
                // System.out.println("index " + op + "left:" + leftMin + "::" + arr[index]);
                // }
            }
            if (st.isEmpty() || (!st.isEmpty() && arr[st.peek()] != arr[index]))
                st.push(index);
        }

        // System.out.println("hello" + ans);
        while (!st.isEmpty()) {
            st.pop();
            int leftMin = !st.isEmpty() ? arr[st.peek()] : 0;
            ans = Math.max(ans, Math.abs(0 - leftMin));
        }
        return ans;
    }
}