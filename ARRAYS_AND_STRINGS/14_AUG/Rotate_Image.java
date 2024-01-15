class Solution {
    public void rotate(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (col > row) {
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = temp;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {

            int start = 0;
            int end = matrix[0].length - 1;

            while (start < end) {
                int temp = matrix[row][start];
                matrix[row][start] = matrix[row][end];
                matrix[row][end] = temp;
                start++;
                end--;
            }
        }

    }
}
