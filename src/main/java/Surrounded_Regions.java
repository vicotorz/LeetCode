/**
 * LeetCode-130
 * https://leetcode.com/problems/surrounded-regions/
 */
public class Surrounded_Regions {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        int width = board.length;
        int hight = board[0].length;

        // 从未封口的边缘圆圈入手，把一定不能封口的区域标记
        // 左
        for (int i = 0; i < width; i++) {
            // 左
            if (board[i][0] == 'O') {
                System.out.println("go into " + i + ",,,," + 0);
                markWrong(board, i, 0);
            }
            // 右
            if (board[i][hight - 1] == 'O') {
                System.out.println("go into " + i + ",,,," + (hight - 1));
                markWrong(board, i, hight - 1);
            }
        }

        for (int i = 0; i < hight; i++) {
            // 上
            if (board[0][i] == 'O') {
                System.out.println("go into " + 0 + ",,,," + i);
                markWrong(board, 0, i);
            }

            // 下
            if (board[width - 1][i] == 'O') {
                System.out.println("go into " + (width - 1) + ",,,," + i);
                markWrong(board, width - 1, i);
            }
        }
        markCircle(board, width, hight);// 将没有标记的圆圈标记，并把‘U’的标记标识回来
    }

    public void markWrong(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 'X' || grid[i][j] == 'U') {
            return;
        } else {
            // 标记不能被包围的圆圈
            grid[i][j] = 'U';// grid[i][j] 确认为O，且不能到达
            markWrong(grid, i - 1, j);
            markWrong(grid, i + 1, j);
            markWrong(grid, i, j - 1);
            markWrong(grid, i, j + 1);
            return;

        }
    }

    // 需要判别是否闭合,保证上下左右都有X
    public void markCircle(char[][] grid, int width, int hight) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < hight; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                } else if (grid[i][j] == 'U') {
                    grid[i][j] = 'O';
                }
            }
        }
    }
}
