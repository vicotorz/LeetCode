import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode-39
 * hard for me
 */
public class Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(candidates);
        formNumber(list,new ArrayList(),candidates,target,0);//如果不引入start，结果将会重复
        return list;
    }

    public boolean formNumber(List<List<Integer>> result, List<Integer> res,int[] candidates,int target,int start) {
        if(target == 0) {
            result.add(new ArrayList(res));//因为递归会使得res结果消失，用这种方法
            return true;
        }

        if(target<0) {
            res=null;
            return false;
        }
        for(int i=start;i<candidates.length;i++) {
            res.add(candidates[i]);
            boolean flag = formNumber(result,res,candidates,target-candidates[i],i);
            res.remove(res.size()-1);

            if(!flag) {
                break;
            }
        }
        return true;
    }
}
