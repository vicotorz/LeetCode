/**
 * LeetCode-258
 * https://leetcode.com/problems/add-digits/
 */
public class Add_Digits {
    public int addDigits(int num) {
        return num % 9 == 0 ? (num == 0 ? 0 : 9) : num % 9;
    }
}
