package DP.PEPCODING_IP.JULY_17;

class Solution {
    public int numTrees(int n) {
        
        return (int) (Permutations(2*n, n)/(n+1));
    }

    public long Permutations(int n, int r) {
        long ans = 1;
        for(int index = 0;index<r;index++) {
            ans*=(n-index); //n! until it reaches n-r! and is cancelled by denominator
            ans/=(index+1); //r!
        }
        return ans;
    }
}
