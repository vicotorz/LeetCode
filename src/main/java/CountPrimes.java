/**
 * LeetCode-224
 * Count Primems
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        } else if (n == 3) {
            return 1;
        }

        boolean[] numMark = new boolean[n];
        numMark[0] = false;
        numMark[1] = false;
        numMark[2] = false;

        // 标记
        for (int i = 2; i < Math.sqrt(n); i++) {

            // 判断当前i是否是质数
            boolean isPrime = true;
            int chu = i - 1;
            while (chu >= 2) {
                if (i % chu == 0) {
                    isPrime = false;
                    break;
                }
                chu--;
            }

            // 如果是质数
            int beishu = 2;
            while (i * beishu < n && isPrime == true) {
                numMark[i * beishu] = true;
                beishu++;
            }
        }

        // 统计没有被标记的
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (numMark[i] == false) {
                cnt++;
            }
        }
        return cnt;
    }
}
