/**
 * LeetCode-27 弱智题
 * 给定一个数据nusm和一个val，原地移除所有数值等于val的原书，返回移除后的数组长度
 */
public class Remove_Element {
    public int removeElement(int[] nums, int val) {
        int res =0;
        for(int num:nums){
            if(num!=val){
                nums[res] = num;
                res++;
            }
        }
        return res;
    }
}
