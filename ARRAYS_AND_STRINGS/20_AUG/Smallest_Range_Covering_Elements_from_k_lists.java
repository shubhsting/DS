import java.util.List;
import java.util.PriorityQueue;
// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/
class Solution {
    class Coordinate {
        int number;
        int listNo;
        int listIndex;

        Coordinate(int number, int listNo, int listIndex) {
            this.number = number;
            this.listNo = listNo;
            this.listIndex = listIndex;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Coordinate> queue = new PriorityQueue<>((Coordinate a, Coordinate b) -> {
            return a.number - b.number;
        });

        int maximum = -1;
        for (int index = 0; index < nums.size(); index++) {
            List<Integer> numList = nums.get(index);
            maximum = Math.max(maximum, numList.get(0));
            queue.add(new Coordinate(numList.get(0), index, 0));
        }
        int ans = Integer.MAX_VALUE;
        int[] range = new int[2];
        while (true) {
            Coordinate current = queue.remove();
            if (maximum - current.number + 1 < ans) {
                range[0] = current.number;
                ans = maximum - current.number + 1;
                range[1] = maximum;
            }
            if (current.listIndex + 1 >= nums.get(current.listNo).size()) {
                break;
            } else {
                int number = nums.get(current.listNo).get(current.listIndex + 1);
                maximum = Integer.max(number, maximum);
                queue.add(new Coordinate(number, current.listNo, current.listIndex + 1));
            }
        }

        return range;
    }
}
