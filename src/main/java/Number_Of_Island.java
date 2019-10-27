/**
 * LeetCode-200
 * hard for me
 */
public class Number_Of_Island {
    public int numIslands(char[][] grid) {
        if(grid.length==0) {
            return 0;
        }

        int width = grid.length;
        int hight = grid[0].length;

        int numIsland = 0;

        for(int i=0;i<width;i++) {
            for(int j =0;j<hight;j++) {
                if(grid[i][j]!='0') {
                    //找到一个1的位置进去
                    numIsland = numIsland+1;
                    getIsland(grid,i,j);
                }
            }
        }
        return numIsland;
    }
    public void getIsland(char[][] grid,int i,int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0') {
            return;
        }else {
            grid[i][j]='0';//grid[i][j] 确认为1，防止重复计算置为0
            getIsland(grid,i-1,j);
            getIsland(grid,i+1,j);
            getIsland(grid,i,j-1);
            getIsland(grid,i,j+1);
            return;
        }
    }
}
