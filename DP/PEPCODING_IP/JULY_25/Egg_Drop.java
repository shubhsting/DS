// o(f^2e) unoptimised
// https://www.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1
class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	   int[][] dp = new int[n+1][k+1];
	  
	       for(int floor = 1; floor<=k; floor++) {
	           dp[1][floor] = floor;
	       }
	       for(int egg = 1; egg<=n; egg++) {
	           dp[egg][1] = 1;
	       }
	       for(int egg = 2; egg<=n; egg++) {
	           for(int floor = 2; floor<=k; floor++) {
	           int currentFloorMoves = Integer.MAX_VALUE;
	           for(int f=1; f<=floor;f++) {
	               //both conditions for case of break /survive
	              int temp = 1 + Math.max(dp[egg - 1][f - 1], dp[egg][floor-f]);
	              currentFloorMoves = Math.min(currentFloorMoves, temp);
	           }
	           dp[egg][floor] = currentFloorMoves;
	       }
	   }
	    return dp[n][k];
	}
}

// //https://leetcode.com/problems/super-egg-drop/description/
// optimised approach f*e
class Solution {
    public int superEggDrop(int k, int n) {
        int[] previousMove = new int[k + 1];
        int[] currentMove = new int[k + 1];
        // dp stores the no of floors in building
        int currentMoveCount = 1;
        while (true) {
            for (int egg = 1; egg <= k; egg++) {
                currentMove[egg] = previousMove[egg - 1] + previousMove[egg] + 1;
                if (currentMove[egg] >= n)
                    return currentMoveCount;
            }
            previousMove = currentMove;
            currentMove = new int[k + 1];
            currentMoveCount++;
        }
    }
}
