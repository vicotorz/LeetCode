/**
 * LeetCode-9
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }

        String str = String.valueOf(x);
        int size = str.length();
        int i = 0,j = size-1;
        for(;i<=j;) {
            if(str.charAt(i)==str.charAt(j)) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
