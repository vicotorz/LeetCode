import java.util.List;

/**
 * LeetCode-139
 */
public class Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];// dp[i]表示为0-i是否可分
        dp[0] = true;
        for (int j = 1; j <= len; j++) {
            for (int i = 0; i < j; i++) {
                //dp[0..i]可分，且i-j可分，所以dp[0..j]可分
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[len];
    }
}
