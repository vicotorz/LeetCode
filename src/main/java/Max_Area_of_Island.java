/**
 * LeetCode-695
 * 基于200. Number of Islands
 */
public class Max_Area_of_Island {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0) {
            return 0;
        }

        int width = grid.length;
        int hight = grid[0].length;

        int maxArea = 0;

        for(int i=0;i<width;i++) {
            for(int j =0;j<hight;j++) {
                if(grid[i][j]!=0) {
                    //找到一个1的位置进去
                    maxArea = Math.max(maxArea, maxArea(grid,i,j));
                }
            }
        }
        return maxArea;
    }

    public int maxArea(int[][] grid,int i,int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0) {
            return 0;
        }else {
            grid[i][j]=0;//grid[i][j] 确认为1，防止重复计算置为0
            return 1+maxArea(grid,i-1,j)+maxArea(grid,i+1,j)+maxArea(grid,i,j-1)+maxArea(grid,i,j+1);
        }
    }
}
