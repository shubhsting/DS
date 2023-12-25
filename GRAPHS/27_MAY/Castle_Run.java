class Solution {
    // complexity: n^2
    // https://practice.geeksforgeeks.org/problems/castle-run3644/1
    // indirectly euler circuit...all nodes should be even.
    public int isPossible(int[][] paths) {
        for (int row = 0; row < paths.length; row++) {
            int noOfEdges = 0;
            for (int col = 0; col < paths[0].length; col++) {
                if (paths[row][col] == 1) {
                    noOfEdges++;
                }
            }
            if (noOfEdges % 2 != 0)
                return 0;
        }
        return 1;
    }
}