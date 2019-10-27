import java.util.ArrayList;
import java.util.List;

/**
 * LeeCode-78
 */
public class SubSets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();

        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            ArrayList<Integer> list = new ArrayList();
            System.out.println(Integer.toBinaryString(i));
            for (int j = Integer.toBinaryString(i).length()-1; j >=0 ; j--) {
                if (Integer.toBinaryString(i).charAt(j) == '1') {
                    list.add(nums[Integer.toBinaryString(i).length()-j-1]);
                }
            }
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> list = subsets(nums);
        for(List<Integer> li:list){
            System.out.print("[");
            for(Integer i:li){
                System.out.print(i+",");
            }
            System.out.print("]");
        }
    }
}
