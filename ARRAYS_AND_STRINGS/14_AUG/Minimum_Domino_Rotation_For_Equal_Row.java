class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/description/
        int choiceOne = tops[0];
        int choiceTwo = bottoms[0];
        int swapTopCountForChoiceOne = 0;
        int swapTopCountForChoiceTwo = 0;
        int swapBottomCountForChoiceOne = 0;
        int swapBottomCountForChoiceTwo = 0;

        for (int index = 0; index < tops.length; index++) {
            if (bottoms[index] != choiceOne && bottoms[index] != choiceTwo) {
                // if top is choice one, there is no choice to get two in either top or bottom
                if (tops[index] == choiceOne) {
                    swapTopCountForChoiceTwo = Integer.MAX_VALUE;
                    swapBottomCountForChoiceTwo = Integer.MAX_VALUE;
                } else if (tops[index] == choiceTwo) {
                    swapTopCountForChoiceOne = Integer.MAX_VALUE;
                    swapBottomCountForChoiceOne = Integer.MAX_VALUE;
                } else {
                    return -1;
                }
            } else if (tops[index] != choiceOne && tops[index] != choiceTwo) {
                if (bottoms[index] == choiceOne) {
                    swapTopCountForChoiceTwo = Integer.MAX_VALUE;
                    swapBottomCountForChoiceTwo = Integer.MAX_VALUE;
                } else if (bottoms[index] == choiceTwo) {
                    swapTopCountForChoiceOne = Integer.MAX_VALUE;
                    swapBottomCountForChoiceOne = Integer.MAX_VALUE;
                } else {
                    return -1;
                }
            } else if (bottoms[index] == choiceOne && tops[index] == choiceOne) {
                swapTopCountForChoiceTwo = Integer.MAX_VALUE;
                swapBottomCountForChoiceTwo = Integer.MAX_VALUE;
            } else if (tops[index] == choiceTwo && bottoms[index] == choiceTwo) {
                swapTopCountForChoiceOne = Integer.MAX_VALUE;
                swapBottomCountForChoiceOne = Integer.MAX_VALUE;
            }

            if (tops[index] == choiceOne && swapBottomCountForChoiceOne != Integer.MAX_VALUE
                    && bottoms[index] != choiceOne) {
                swapBottomCountForChoiceOne++;
            }
            if (tops[index] == choiceTwo && swapBottomCountForChoiceTwo != Integer.MAX_VALUE
                    && bottoms[index] != choiceTwo) {
                swapBottomCountForChoiceTwo++;
            }
            if (bottoms[index] == choiceOne && swapTopCountForChoiceOne != Integer.MAX_VALUE
                    && tops[index] != choiceOne) {
                swapTopCountForChoiceOne++;
            }
            if (bottoms[index] == choiceTwo && swapTopCountForChoiceTwo != Integer.MAX_VALUE
                    && tops[index] != choiceTwo) {
                swapTopCountForChoiceTwo++;
            }
        }

        int ans = Math.min(Math.min(swapBottomCountForChoiceOne, swapBottomCountForChoiceTwo),
                Math.min(swapTopCountForChoiceOne, swapTopCountForChoiceTwo));
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
