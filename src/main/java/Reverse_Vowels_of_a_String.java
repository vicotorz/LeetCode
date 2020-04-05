import java.util.HashSet;

/**
 * leetcode-345
 *
 * */
public class Reverse_Vowels_of_a_String {

    public String reverseVowels(String s) {
        if (s == null || s.isEmpty() || s.length() == 0) {
            return s;
        }

        HashSet<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char[] chrs = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {

            while (left < chrs.length && !set.contains(chrs[left])) {
                left++;
            }

            while (right >= 0 && !set.contains(chrs[right])) {
                right--;
            }

            if (left <= right) {
                swap(left, right, chrs);
                left++;
                right--;
            } else {
                break;
            }
        }

        StringBuffer result = new StringBuffer();
        for (char ch : chrs) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void swap(int left, int right, char[] chrs) {
        char tmp = chrs[left];
        chrs[left] = chrs[right];
        chrs[right] = tmp;
    }
}
