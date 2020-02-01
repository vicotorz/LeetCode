/**
 * LeetCode-547
 * https://leetcode.com/problems/friend-circles/
 */
public class Friend_Circles {
    public int findCircleNum(int[][] M) {
        if(M==null||M.length==0) {return 0;}

        if(M==null||M.length==0) {return 0;}

        int res=0;
        boolean[] visited = new boolean[M.length];

        for(int i=0;i<M.length;i++) {
            if(visited[i]) { continue;}
            helper(M,i,visited);
            ++ res;
        }
        return res;
    }

    public static void helper(int[][] M,int k,boolean[] visited) {
        visited[k] = true;
        for(int i=0;i<M.length;++i) {
            if((M[k][i]==0) || visited[i]) {
                continue;
            }
            helper(M,i,visited);
        }
    }
}
