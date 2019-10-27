/**
 * LeetCode-73
 */
public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = -1;
                    column[j] = -1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            boolean isRowZero = row[i] == -1 ? true : false;
            for (int j = 0; j < matrix[0].length; j++) {
                boolean isColZero = column[j] == -1 ? true : false;
                if (isRowZero) {
                    matrix[i][j] = 0;
                } else if (isColZero) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
