// https://www.geeksforgeeks.org/problems/optimal-binary-search-tree2214/1
class Solution {
    static int optimalSearchTree(int keys[], int freq[], int n) {

        int[][][] dp = new int[n + 1][n + 1][n + 1];
        for (int[][] bd : dp) {
            for (int[] d : bd)
                Arrays.fill(d, -1);
        }
        return optimalBST(keys, freq, 1, 0, keys.length - 1, dp);
    }

    static int optimalBST(int[] keys, int[] freq, int level, int start, int end, int[][][] dp) {
        if (end < start)
            return 0;
        if (dp[start][end][level] != -1)
            return dp[start][end][level];
        int ans = Integer.MAX_VALUE;
        for (int index = start; index <= end; index++) {
            int temp = optimalBST(keys, freq, level + 1, start, index - 1, dp)
                    + optimalBST(keys, freq, level + 1, index + 1, end, dp) + level * freq[index];
            ans = Math.min(ans, temp);
        }
        return dp[start][end][level] = ans;
    }


class Solution
{
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        
        int[][] dp = new int[n + 1][n + 1];
        
        for(int [] d: dp) Arrays.fill(d,-1);
        
       return optimalBST(keys, freq, 0, keys.length-1, dp);
    }
    
    static int optimalBST(int[] keys, int[] freq, int start, int end, int[][] dp) {
        if(end<start) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        int s = sum(freq, start, end);
        int ans = Integer.MAX_VALUE;
        for(int index = start; index<=end; index++) {
            int temp = optimalBST(keys, freq, start, index-1, dp) + optimalBST(keys, freq, index+1, end, dp);
            ans = Math.min(ans, temp);
        }
        return dp[start][end] = s+ans;
    }
    
    static int sum(int[] freq, int start,int end) {
        int sum=0;
        for(int index = start; index<=end; index++) sum+=freq[index];
        return sum;
    }
}

class Solution
{
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        
        int[][] dp = new int[n + 1][n + 1];
        
        for(int [] d: dp) Arrays.fill(d,-1);
        
       return optimalBST(keys, freq, 0, keys.length-1, dp);
    }
    
    static int optimalBST(int[] keys, int[] freq, int start, int end, int[][] dp) {
        if(end<start) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        int s = sum(freq, start, end);
        int ans = Integer.MAX_VALUE;
        for(int index = start; index<=end; index++) {
            int temp = optimalBST(keys, freq, start, index-1, dp) + optimalBST(keys, freq, index+1, end, dp);
            ans = Math.min(ans, temp);
        }
        return dp[start][end] = s+ans;
    }
    
    static int sum(int[] freq, int start,int end) {
        int sum=0;
        for(int index = start; index<=end; index++) sum+=freq[index];
        return sum;
    }
}