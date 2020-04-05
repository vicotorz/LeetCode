import java.util.Arrays;
/**
 * leetcode-1365
 * */
public class SmallerNumber {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        if(nums==null||nums.length==0) {
            return new int[0];
        }

        int[] sortNums = Arrays.copyOf(nums,nums.length);
        Arrays.sort(sortNums);

        int[] result = new int[nums.length];

        for(int i=0;i<nums.length;i++) {
            result[i] = getTargetLeft(sortNums,nums[i]);
        }
        return result;
    }

    public static int getTargetLeft(int[] nums,int key) {

        int low = 0;
        int high = nums.length - 1;
        int middle = 0;			//定义middle

        if(key < nums[low] || key > nums[high] || low > high){
            return -1;
        }

        while(low <= high){
            middle = (low + high) / 2;
            if(nums[middle] > key){
                //比关键字大则关键字在左区域
                high = middle - 1;
            }else if(nums[middle] < key){
                //比关键字小则关键字在右区域
                low = middle + 1;
            }else{

                //找最左匹配

                int cur = middle;
                while(cur>=0 && nums[cur]==nums[middle]) {
                    cur--;
                }
                return cur+1;
            }
        }

        return -1;		//最后仍然没有找到，则返回-1
    }
}
