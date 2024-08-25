//https://leetcode.com/problems/asteroid-collision/
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            int currentAsteroid = asteroid;
            while (!st.isEmpty() && st.peek() > 0 && willExplode(st.peek(), currentAsteroid)) {
                int explodedAsteroid = Math.min(Math.abs(st.peek()), Math.abs(currentAsteroid));
                // this means both are same size
                if (explodedAsteroid == Math.abs(st.peek()) && explodedAsteroid == Math.abs(currentAsteroid)) {
                    st.pop();
                    currentAsteroid = Integer.MIN_VALUE;
                } else if (explodedAsteroid == Math.abs(st.peek())) {
                    st.pop();
                } else {
                    currentAsteroid = Integer.MIN_VALUE;
                    break;
                }
            }
            if (currentAsteroid == asteroid)
                st.push(asteroid);
        }

        int[] ans = new int[st.size()];
        int idx = ans.length - 1;
        while (!st.isEmpty()) {
            ans[idx] = st.pop();
            idx--;
        }
        return ans;
    }

    public boolean willExplode(int a1, int a2) {
        return (a1 < 0 && a2 > 0) || (a1 > 0 && a2 < 0);
    }
}