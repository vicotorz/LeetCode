import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode-437
 * hard for me
 */
public class Path_Sum_III {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer,Integer> map = new HashMap();
        //<和，次数>
        map.put(0, 1);
        return FindSubTree(root,0,sum,map);
    }

    public int FindSubTree(TreeNode root,int sum,int target,Map<Integer,Integer> map) {
        if(root==null) {
            return 0;
        }
        sum +=root.val;

        int res = map.getOrDefault(sum-target, 0);
        map.put(sum, map.getOrDefault(sum, 0)+1);

        res +=FindSubTree(root.left,sum,target,map);
        res +=FindSubTree(root.right,sum,target,map);

        //回溯
        map.put(sum, map.get(sum)-1);
        return res;
    }
}
