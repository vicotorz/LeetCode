import java.util.*;

/**
 * LeetCode-384
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class Shuffle_an_array {
    int[] originnums;
    int[] tmpnums;

    public Shuffle_an_array(int[] nums) {
        originnums = Arrays.copyOf(nums, nums.length);
        tmpnums = Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return tmpnums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> list = new ArrayList();
        for(int e:originnums) {
            list.add(e);
        }
        Collections.shuffle(list);
        int[] result = new int[list.size()];

        Iterator<Integer> it = list.iterator();
        int loc = 0;
        while(it.hasNext()) {
            result[loc] = it.next();
            loc++;
        }
        return result;
    }
}
