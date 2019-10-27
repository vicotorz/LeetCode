/**
 * LeetCode-55
 */
public class JumpGames {
    public boolean canJump(int[] nums) {
        int lastIndex = 0;//最后能到达的位置
        boolean res = false;
        for (int i = 0; i < nums.length; i++) {

            if (lastIndex >= i) {
                lastIndex = Math.max(lastIndex,i + nums[i]);
            }
            if (lastIndex >= nums.length-1) {
                res = true;
                break;
            }
        }
        return res;
    }
}
