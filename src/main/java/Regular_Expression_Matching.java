/**
 * LeetCode-10
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * hard for me
 */
public class Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        // https://www.jianshu.com/p/c09c4a3fc14a
        // dp[s.length()+1][p.length()+1];
        // dp[i][j] 表示 s[0...i] 与 p[0...j]是否匹配
        // dp[0][j] = j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2];
        // dp[i][0] = false

//	 完全匹配：       p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]
//	    如果p为“.”    		If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
//	    如果p为“*”      		If p.charAt(j) == '*':
//	        		here are two sub conditions:
//	  看一下p前一个元素  --不等      		- if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] //in this case, a only counts as empty
//	  看一下 p前一个元素 --等      		- if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':

        // 只有当前字符匹配了*之前的字符，才有资格传递dp[i-1][j]真值
        // dp[i][j-2] || (s[i-1] == p[j-2] || p[j-2] == '.') && dp[i-1][j];

//	        		dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
//	        		dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
//	        		dp[i][j] = dp[i][j-2] // in this case, a* counts as empty

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2];
        }
        // System.out.println(dp.length + ",,,," + dp[0].length);
        for (int row = 1; row < dp.length; row++) {
            for (int column = 1; column < dp[0].length; column++) {
                // 完全匹配
                if (s.charAt(row - 1) == p.charAt(column - 1)) {
                    dp[row][column] = dp[row - 1][column - 1];
                } else if (p.charAt(column - 1) == '.') {
                    dp[row][column] = dp[row - 1][column - 1];
                } else if (p.charAt(column - 1) == '*') {
                    dp[row][column] = dp[row][column - 2]
                            || (s.charAt(row - 1) == p.charAt(column - 2) || p.charAt(column - 2) == '.')
                            && dp[row - 1][column];
                }
            }
        }
//		String p_tmp = new String(" "+p);
//		String s_tmp = new String(" "+s);
//
//		System.out.print(" ");
//		for(int kk=0;kk<p.length();kk++) {
//			System.out.print(p_tmp.charAt(kk)+" ");
//		}
//		System.out.println();
//		for (int ii = 0; ii < dp.length; ii++) {
//			System.out.print(s_tmp.charAt(ii)+" ");
//			for (int jj = 0; jj < dp[0].length; jj++) {
//				System.out.print(dp[ii][jj]==true?"T ":"F" + " ");
//			}
//			System.out.println();
//		}

        return dp[s.length()][p.length()];
    }
}
