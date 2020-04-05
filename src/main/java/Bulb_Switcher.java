
/**
 * leetcode-319
 *
 * hard for me
 * */
public class Bulb_Switcher {
    public int bulbSwitch(int n) {
        if(n<0) {
            return 0;
        }

        return (int) Math.sqrt(n);
    }
}
