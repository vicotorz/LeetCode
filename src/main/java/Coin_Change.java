/**
 * LeetCode-322
 * need to think of initialization
 */
public class Coin_Change {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) {
            return 0;
        }
        // dp[i] 表示钱数为i的总方式
        // dp[i]=总和(dp[i-coin]) else -1
        //初始化
        //我们需要给dp[i]赋一初值，这个初值赋值为可能的最大值。也就是需要找零的面额amount+1的值。如果存在能够进行找零的情况，那么最终的dp[i]的值一定是比amount+1少的。
        int[] dp = new int[amount + 1];

        for(int y=0;y<dp.length;y++) {
            dp[y]=amount+1;
        }
        dp[0] = 0;
        for(int i=1;i<=amount;i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j]<=i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        // for(int t:dp) {
        // 	System.out.print(t+" ");
        // }
        // System.out.println();
        return (dp[amount] == (amount + 1))?-1:dp[amount];
    }
}
