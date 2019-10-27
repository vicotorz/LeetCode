/**
 * LeetCode-221
 * hard for me
 */
public class Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // dp[i][j] 代表边
        // dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j-1],dp[i-1][j])+1
        int maxLength = 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];

        for (int i = 1; i <=matrix.length; i++) {
            for (int j = 1; j <=matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return maxLength * maxLength;
    }
}
