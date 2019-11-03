/**
 * LeetCode-69
 */
public class Sqrt {
    static double e=0.01;
    public int mySqrt(int x) {
        double n = (double)x;
        double tmp = n/2;
        while(Math.abs(n-tmp*tmp)>e) {
            tmp = (n/tmp +tmp)/2;
        }
        return (int)tmp;
    }
}
