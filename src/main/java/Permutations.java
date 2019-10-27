import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode-47
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();

        if (nums.length == 0 || nums == null)
            return res;
        boolean[] visited = new boolean[nums.length];
        permutation_helper(nums, res, item, visited);
        return res;
    }

    public void permutation_helper(int[] num, List<List<Integer>> res, List<Integer> item, boolean[] visited) {
        if (item.size() == num.length) {
            res.add(new ArrayList(item));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                item.add(num[i]);
                visited[i] = true;
                permutation_helper(num, res, item, visited);
                item.remove(item.size() - 1);
                visited[i] = false;
            }
        }
    }
}
