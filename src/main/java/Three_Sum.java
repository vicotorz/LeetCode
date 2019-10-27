import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode-15
 */
public class Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList();
        int a, b, target;
        for (int x = 0; x < nums.length; x++) {//x用于指定第三个值
            a = 0;
            b = nums.length - 1;
            target = nums[x];
            while (a < b) {
                List<Integer> list = new ArrayList();
                // System.out.println("target-->" + target + ",,," + nums[a] + ",,," + nums[b]);
                if (nums[a] + nums[b] + target == 0) {
                    if (a == x) {
                        a++;
                    } else if (b == x) {
                        b--;
                    } else {//确定了这组结果
                        int[] tmpNum = new int[3];
                        tmpNum[0] = nums[x];
                        tmpNum[1] = nums[a];
                        tmpNum[2] = nums[b];
                        Arrays.sort(tmpNum);
                        list.add(tmpNum[0]);
                        list.add(tmpNum[1]);
                        list.add(tmpNum[2]);
                        //System.out.println("bingo!");
                        //System.out.println(tmpNum[0] + ",,," + tmpNum[1] + ",,," + tmpNum[2]);
                        //System.out.println(nums[x] + ",,," + nums[a] + ",,," + nums[b]);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                        a++;
                        b--;
                    }
                }
                if (nums[a] + nums[b] + target < 0) {
                    a++;
                }
                if (nums[a] + nums[b] + target > 0) {
                    b--;
                }
            }
        }

        return result;
    }
}
