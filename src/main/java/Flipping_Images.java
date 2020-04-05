
/**
 * leetcode-832
 * */
public class Flipping_Images {
    public static int[][] flipAndInvertImage(int[][] A) {

        if (A == null || A.length < 0) {
            return A;
        }

        for (int row = 0; row < A.length; row++) {
            int x = 0;
            int y = A[0].length - 1;
            while (x <= y) {
                swapAndConvert(A, row, x, y);
                x++;
                y--;
            }
        }
        return A;
    }

    private static void swapAndConvert(int[][] A, int row, int x, int y) {
        // 水平翻转
        // 图像反转
        int tmp = A[row][x];
        A[row][x] = (A[row][y]==1?0:1);
        A[row][y] = (tmp==1?0:1);
    }
}
