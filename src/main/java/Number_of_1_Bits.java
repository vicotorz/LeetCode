/**
 * LeetCode-191
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class Number_of_1_Bits {
    public int hammingWeight(int n) {
        int sum = 0;
        if (n < 0) {
            n = Integer.MAX_VALUE - ~n;// 然后计算0的个数
            sum++;
        }
        while (n != 0) {
            sum += (n & 1) == 1 ? 1 : 0;
            n = n >> 1;
        }
        return sum;
    }
}
