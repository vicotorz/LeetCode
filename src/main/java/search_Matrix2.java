/**
 * LeetCode-240
 */
public class search_Matrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;

        boolean res = false;

        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j]) {
                res = true;
                break;
            } else if (target < matrix[i][j]) {
                j--;
            } else if (target > matrix[i][j]) {
                i++;
            }
        }
        return res;
    }
}
