/**
 * LeetCode-994
 * https://leetcode.com/problems/rotting-oranges/
 */
public class Rotting_Oranges {
    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length==0) {
            return 0;
        }
        int turn = 0;
        boolean isRotted = true;

        while(isRotted) {
            boolean tmpRotted = false;
            //这里犯同一个错误，更新之后，影响后面的状态判断
            //影响上下左右
            for(int i=0;i<grid.length;i++) {
                for(int j=0;j<grid[0].length;j++) {
                    if(grid[i][j]==2) {
                        tmpRotted = RottingOrange(grid,i,j) || tmpRotted;
                    }
                }
            }

            if(tmpRotted) {turn++;}

            isRotted = isRotted && tmpRotted;

            for(int i=0;i<grid.length;i++) {
                for(int j=0;j<grid[0].length;j++) {
                    if(grid[i][j]==3) {
                        grid[i][j]=2;
                    }
                }
            }
        }

        //检查矩阵的情况
        if(!checkMatrix(grid)) {
            turn = -1;
        }

        return turn;
    }

    public static boolean checkMatrix(int[][] grid) {
        boolean res = true;
        //影响上下左右
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    public static boolean RottingOrange(int[][] grid,int i, int j) {
        boolean isRotted = false;

        int top = Math.max(0, i - 1);
        int bottom = Math.min(grid.length - 1, i + 1);
        int left = Math.max(0, j - 1);
        int right = Math.min(grid[0].length - 1, j + 1);


        int preSum = grid[top][j] + grid[bottom][j] + grid[i][left] + grid[i][right];

        grid[top][j] = grid[top][j]==1?3:grid[top][j];
        grid[bottom][j] = grid[bottom][j]==1?3:grid[bottom][j];
        grid[i][left] = grid[i][left]==1?3:grid[i][left];
        grid[i][right] = grid[i][right]==1?3:grid[i][right];
        int afterSum = grid[top][j] + grid[bottom][j] + grid[i][left] + grid[i][right];

        isRotted = preSum==afterSum?false:true;

        return isRotted;
    }
}
