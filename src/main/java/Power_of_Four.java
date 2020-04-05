
/**
 * LeetCode-342
 */
public class Power_of_Four {

    public boolean isPowerOfFour(int num) {
        if(num == 0)
            return false;
        double log10 = Math.log10(num);
        double log4 = Math.log10(4);
        return log10/log4 == (int)(log10/log4);
    }
}
