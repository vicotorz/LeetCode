import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode-645
 * */

public class Set_Mismatch {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Set set1 = new HashSet();
        Set set2 = new HashSet();
        Set set3 = new HashSet();

        Arrays.sort(nums);

        int targetNum = -1;
        int preNum = -1;
        for(int i=1;i<=nums.length;i++) {
            set1.add(i);
            set2.add(nums[i-1]);
            if(nums[i-1]==preNum) {
                targetNum = nums[i-1];
            }
            preNum = nums[i-1];
        }

        set3.clear();
        set3.addAll(set1);
        set3.removeAll(set2);
        result[1] = (int)set3.toArray()[0];

        result[0] = targetNum;

        return result;
    }
}
