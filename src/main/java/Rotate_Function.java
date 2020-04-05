
/**
 * leetcode-396
 *
 * need to optimize
 * */
public class Rotate_Function {
    public int maxRotateFunction(int[] A) {
        if(A==null||A.length==0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for(int times=0;times<A.length;times++) {
            int F = 0;

            for(int i=-times;i<-times + A.length;i++) {
                //System.out.println((times+i)+"------"+(A[i<0?A.length+i:i]));
                F = F+ (times+i) * (A[i<0?A.length+i:i]);

            }
            //System.out.println(F);
            max = Math.max(max, F);
        }

        return max;
    }
}
