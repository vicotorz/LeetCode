/**
 * LeetCode-121
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if(prices.length==0) {
            return 0;
        }
        int minStock=prices[0];//维护一个最小值即可
        int maxStock=0;
        for(int i=0;i<prices.length;i++) {
            if(prices[i]<minStock) {
                minStock=prices[i];
            }
            if(prices[i]-minStock>maxStock) {
                maxStock = prices[i]-minStock;
            }
        }
        return maxStock;
    }
}
