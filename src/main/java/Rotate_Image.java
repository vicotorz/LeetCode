/**
 * LeetCode-48
 */
public class Rotate_Image {
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0) {
            return;
        }
        //思路：  先按照对角线对矩阵进行翻转，然后每行进行翻转
        int n = matrix.length;
        //按对角线翻转
        //（x,y）和(y,x)对换，算一个对角即可
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                int tmp = matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=tmp;
            }
        }
        //每行翻转
        //(x,y)与(x,n-1-y)对换，算一半即可
        for(int i=0;i<n;i++) {
            for(int j=0;j<(n/2);j++) {
                int tmp = matrix[i][n-1-j];
                matrix[i][n-1-j] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}
