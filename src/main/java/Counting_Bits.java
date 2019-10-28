/**
 * LeetCode-338
 */
public class Counting_Bits {
    public int[] countBits(int num) {

        if(num==0) {
            int[] res = new int[1];
            res[0]=0;
            return res;
        }

        //有规律
        //0 ~ pow(2,n)-1
        //pow(2,n) ~ pow(2,n+1)-1  比  0 ~ pow(2,n)-1 每个值都+1
        //dp[n]=dp[n-pow(2,m)]+1
        int[] res = new int[num+1];
        res[0]=0;
        res[1]=1;
        int m =1;
        while(true) {
            if(Math.pow(2, m)<=num&&Math.pow(2, m+1)>num||num==1) {
                break;
            }else {
                m++;
            }
        }
        for(int i=1;i<=m;i++) {
            for(int j=(int) Math.pow(2, i);j<=(int)Math.pow(2, i+1)-1 && j<res.length;j++) {
                res[j]=res[(int) (j-Math.pow(2, i))]+1;
            }
        }
        return res;
    }
}
