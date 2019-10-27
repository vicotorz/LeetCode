/**
 * LeetCode-34
 */
public class Find_First_and_Last_Position {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            int[] res = new int[2];
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        // 二分法先找到一个target
        // 前后确定第一个和最后一个
        int start = 0;
        int end = nums.length - 1;

        int medium = (start + end) / 2;

        int firstLoc = -1;
        int lastLoc = -1;
        while (start <= end) {
            if (nums[medium] == target) {
                firstLoc = medium;
                lastLoc = medium;
                while (firstLoc >= start && (firstLoc >= 1 && (nums[firstLoc - 1] == nums[firstLoc]))) {
                    firstLoc--;
                }
                while (lastLoc <= end && (lastLoc <= nums.length - 2 && (nums[lastLoc] == nums[lastLoc + 1]))) {
                    lastLoc++;
                }
                break;
            } else if (nums[medium] < target) {
                start = medium + 1;
            } else if (nums[medium] > target) {
                end = medium - 1;
            }
            medium = (start + end) / 2;
        }

        int[] res = new int[2];
        res[0] = firstLoc;
        res[1] = lastLoc;
        return res;
    }
}
