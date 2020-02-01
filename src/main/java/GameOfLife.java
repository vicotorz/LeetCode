/**
 * LeetCode-289
 * https://leetcode.com/problems/game-of-life/
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0) {
            return;
        }

        // 标记
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                checkAround(board, i, j);
            }
        }

        //printMatrix(board);

        // 重新整理
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((board[i][j] == 0 || board[i][j] == 1)) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static void checkAround(int[][] board, int i, int j) {
        // 检查i，j周边的细胞状态
        int top = Math.max(0, i - 1);
        int bottom = Math.min(board.length - 1, i + 1);
        int left = Math.max(0, j - 1);
        int right = Math.min(board[0].length - 1, j + 1);

        int count = 0;// 周边的活结点情况
        for (int row = top; row <= bottom; row++) {
            for (int column = left; column <= right; column++) {
                if (board[row][column] == 1 || board[row][column] == 3) {
                    count++;
                }
            }
        }
//		die <- die 00
//		die <- live 01
//		live <- die 10
//		live <- live 11
        if (board[i][j] == 0) {
            // dead
            if (count == 3) {
                board[i][j] = 2;
            } else {
                board[i][j] = 0;
            }
        } else {
            // alive
            count--;
            if (count == 2 || count == 3) {
                board[i][j] = 3;
            } else {
                board[i][j] = 1;
            }
        }
    }
}
