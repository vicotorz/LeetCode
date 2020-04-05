
/**
 * Reverse Bits
 *
 * leetcode-190
 *
 * hard for me
 * */
public class ReverseBits {

    public int reverseBits(int n) {
        int s = 0, e = 31;
        while(s < e) {
            if( ( (n >> s) & 1)  != ( (n >> e) & 1) ) { // swap only if not equal
                n = n ^ (1 << s);  // flip s'th bit
                n = n ^ (1 << e);  // flip e'th bit
            }
            s++;
            e--;
        }
        return n;
    }
}
