//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
class Solution {
    class Element {
        int row;
        int column;
        int value;

        Element(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((Element a, Element b) -> {
            return a.value - b.value;
        });
        for (int row = 0; row < matrix.length; row++) {
            pq.add(new Element(row, 0, matrix[row][0]));
        }
        int element = 0;
        while (pq.size() != 0) {
            Element ele = pq.remove();
            element++;
            if (ele.column + 1 < matrix[0].length)
                pq.add(new Element(ele.row, ele.column + 1, matrix[ele.row][ele.column + 1]));
            if (element == k)
                return ele.value;
        }
        return -1;
    }
}
