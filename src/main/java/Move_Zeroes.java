/**
 * Created by dell on 2019/10/28.
 */
public class Move_Zeroes {
    public void moveZeroes(int[] nums) {
        //双指针
        int i=0;//找0，保持比j小
        int j=0;//找非0

        while(i<=j) {
            if(nums[i]!=0&&i<nums.length&&i<j) {
                i++;
            }
            if((nums[j]==0&&j<nums.length)||j<=i) {
                j++;
            }
            if(i>=nums.length||j>=nums.length||i>j) {
                break;
            }
            if(nums[i]==0&&nums[j]!=0){
                int tmp =nums[j];
                nums[j] =nums[i];
                nums[i] =tmp;
            }
        }
    }
}
