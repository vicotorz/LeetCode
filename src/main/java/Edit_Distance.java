/**
 * LeetCode-72
 * hard for me
 */
public class Edit_Distance {
    public static int minDistance(String word1, String word2) {
        //dp[i+1][j+1]表示A[0..i]与B[0..j]的编辑距离
        //初始值：dp[i][j] = Max(i,j)  if Min(i,j)=0
        //dp[i][j]=min
        //插入： dp[i][j-1]+1  //插入B[i],用B末尾插入A末尾一个字符(insertion)
        //删除： dp[i-1][j]+1  //删除A[i],删除A末尾一个字符(deletion)
        //替换： dp[i-1][j-1]+x (A[i-1]==B[j-1] x=0/x=1)



        int[][] dp = new int[word1.length()+1][word2.length()+1];

        //初值
        for(int i=0;i<word1.length()+1;i++) {
            dp[i][0] = Math.max(i, 0);
        }

        for(int j=0;j<word2.length()+1;j++) {
            dp[0][j] = Math.max(j, 0);
        }


        for(int i=1;i<word1.length()+1;i++) {
            for(int j=1;j<word2.length()+1;j++) {
                int insertDistance = dp[i][j-1]+1;
                int deleteDistance = dp[i-1][j]+1;
                int l;
                if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    l=0;//无需编辑
                }else {
                    l=1;
                }
                int replaceDistance = dp[i-1][j-1]+l;
                dp[i][j]=Math.min(insertDistance, Math.min(deleteDistance, replaceDistance));
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
