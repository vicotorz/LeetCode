import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode-350
 * */
public class Intersection_of_Two_ArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null) {
            return null;
        }

        HashMap<Integer,Integer> num1Map = new HashMap();
        HashMap<Integer,Integer> num2Map = new HashMap();

        for(int i=0;i<nums1.length;i++) {
            num1Map.put(nums1[i], num1Map.getOrDefault(nums1[i], 0)+1);
        }

        for(int j=0;j<nums2.length;j++) {
            num2Map.put(nums2[j], num2Map.getOrDefault(nums2[j], 0)+1);
        }
        ArrayList<Integer> res = new ArrayList();

        for(Map.Entry<Integer,Integer> entry:num1Map.entrySet()) {
            if(num2Map.containsKey(entry.getKey())) {
                int nums = entry.getValue()>num2Map.get(entry.getKey())?
                        num2Map.get(entry.getKey()):entry.getValue();

                for(int i=0;i<nums;i++) {
                    res.add(entry.getKey());
                }
            }
        }

        int[] arr = new int[res.size()];

        for(int i=0;i<res.size();i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }
}
