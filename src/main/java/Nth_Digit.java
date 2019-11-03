/**
 * LeetCode-400
 */
public class Nth_Digit {
    //注意一定要用long，不能用int
    public int findNthDigit(int n) {
        if(n<=0) {
            return 0;
        }

        //确定是落在几位数的范围
        int weiShu = 1;
        long start = 1;
        long end = (int) (Math.pow(10, weiShu)-1);
        long totaldigit = 0;
        //1位数占用1-9 9个长度
        //2位数占用11-99 180个长度
        while(totaldigit<Integer.MAX_VALUE) {
            totaldigit = (end-start+1)*weiShu;
            if(n<=totaldigit) {
                break;
            }else {
                //System.out.println("totaldigit--"+totaldigit);
                n = n- (int)totaldigit;//减去不输入这个区间的占用
                weiShu++;
                start = end+1;
                end= (int) (Math.pow(10, weiShu)-1);
            }
        }
        //System.out.println(start+"---"+end+"######"+weiShu+"$$$$"+n);
        //确定了n 在[start,end]区间，位数是weiShu，这个区间一个数字占用weiShu个
        long num = start + n/weiShu;//确定是这个数
        if(n%weiShu==0) {
            num = num-1;
        }
        char c = String.valueOf(num).charAt(n%weiShu==0?String.valueOf(num).length()-1:n%weiShu-1);
        int res = Integer.valueOf(String.valueOf(c));
        return res;
    }
}
