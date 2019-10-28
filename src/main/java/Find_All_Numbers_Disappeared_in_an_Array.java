import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode-448
 */
public class Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> res = new ArrayList();

        boolean[] num = new boolean[nums.length+1];

        for(int i=0;i<nums.length;i++) {
            num[nums[i]] = true;
        }

        for(int j=1;j<=nums.length;j++) {
            if(!num[j]) res.add(j);
        }
        return res;
    }
}
