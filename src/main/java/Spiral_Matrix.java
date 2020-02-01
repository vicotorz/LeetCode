import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode-54
 * https://leetcode.com/problems/spiral-matrix/
 */
public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<Integer>();
        } else {
            int lrow = 0;
            int rrow = matrix.length - 1;
            int lcolumn = 0;
            int rcolumn = matrix[0].length - 1;
            int size = (rrow + 1) * (rcolumn + 1);
            ArrayList<Integer> list = new ArrayList<Integer>();
            // 定义四种状态
            int status = 0;
            while (list.size() != size) {

                if (status > 3) {
                    status = 0;
                }
                if (status == 0) {
                    // 行不动 列增
                    for (int i = lcolumn; i <= rcolumn; i++) {

                        list.add(matrix[lrow][i]);
                    }
                    lrow = lrow + 1;
                } else if (status == 1) {
                    // 列不动 行增
                    for (int i = lrow; i <= rrow; i++) {
                        list.add(matrix[i][rcolumn]);
                    }
                    rcolumn = rcolumn - 1;

                } else if (status == 2) {
                    // 行不动 列减
                    for (int i = rcolumn; i >= lcolumn; i--) {
                        list.add(matrix[rrow][i]);
                    }
                    rrow = rrow - 1;
                } else if (status == 3) {
                    // 列不动 行减
                    for (int i = rrow; i >= lrow; i--) {
                        list.add(matrix[i][lcolumn]);
                    }
                    lcolumn = lcolumn + 1;
                }
                status++;
            }
            return list;
        }
    }
}
