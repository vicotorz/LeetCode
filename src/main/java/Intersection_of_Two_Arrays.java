import java.util.HashSet;
import java.util.Iterator;

/**
 * leetcode-349
 * */
public class Intersection_of_Two_Arrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        if (nums1.length == 0 || nums2.length == 0) {
            return nums1.length == 0 ? nums1 : nums2;
        }

        HashSet<Integer> set1 = new HashSet();
        HashSet<Integer> set2 = new HashSet();

        for (int num1 : nums1) {
            set1.add(num1);
        }

        for (int num2 : nums2) {
            set2.add(num2);
        }

        HashSet<Integer> set3 = new HashSet();
        set3.clear();
        set3.addAll(set1);
        set3.retainAll(set2);

        int[] num3 = new int[set3.size()];

        Iterator<Integer> it = set3.iterator();
        for (int i = 0; i < set3.size(); i++) {
            num3[i] = it.next();
        }

        return num3;
    }
}
