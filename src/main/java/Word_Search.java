/**
 * LeetCode-79
 */
public class Word_Search {
    public boolean exist(char[][] board, String word) {
        if(word.equals("")||word ==null||board==null) {
            return false;
        }

        int size=board.length;
        int length = board[0].length;
        char headStr = word.charAt(0);
        for(int i=0;i<size;i++) {
            for(int j=0;j<length;j++) {
                if(board[i][j]==headStr) {
                    if(existDeep(board,size,length,i,j,word)) {//从i,j位置递归找
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean existDeep(char[][] board,int size,int length,int x,int y, String word) {
        if(word.equals("")) {
            return true;
        }
        //System.out.println(x+"####"+y);
        if(y<0||x<0||x==size||y==length||word.charAt(0)!=board[x][y]) {
            return false;
        }
        char c = board[x][y];
        board[x][y]='#';//遍历完标志
        //找i,j四周的字母
        boolean res = existDeep(board,size,length,x-1,y,word.substring(1))
                || existDeep(board,size,length,x+1,y,word.substring(1))
                || existDeep(board,size,length,x,y-1,word.substring(1))
                || existDeep(board,size,length,x,y+1,word.substring(1));

        board[x][y]=c;//遍历完再恢复回来

        return res;

    }
}
