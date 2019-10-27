import java.util.HashSet;

/**
 * LeetCode-202
 */
public class Happy_Number {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }

        boolean flag = false;
        HashSet<Integer> set = new HashSet();

        while (true) {
            if (n / 10 == 0 && n == 1) {
                flag = true;
                break;
            }
            //处理n
            int result=0;
            for(int i=String.valueOf(n).length()-1;i>=0;i--) {
                int chu = (int) (n/Math.pow(10, i));
                int yu =(int) (n%Math.pow(10, i));
                result += Math.pow(chu, 2);
                n=yu;
            }
            n=result;
            //System.out.println(n);
            if (set.contains(n)) {
                break;
            }
            set.add(n);
        }
        return flag;
    }
}
