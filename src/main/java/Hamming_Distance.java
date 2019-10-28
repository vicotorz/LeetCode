/**
 * LeetCode-461
 */
public class Hamming_Distance {
    public int hammingDistance(int x, int y) {
        //转换binary后异或
        String res = Integer.toBinaryString(x^y);
        int num = 0;
        for(int i=0;i<res.length();i++) {
            if(res.charAt(i)=='1') {
                num++;
            }
        }
        return num;
    }
}
