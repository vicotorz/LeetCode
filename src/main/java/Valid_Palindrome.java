import java.util.regex.Pattern;
/**
 * leetcode-125
 * */
public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()<=0) {
            return true;
        }

        String pattern = "[0-9a-zA-Z]";
        String pattern2 ="[a-z]";
        String pattern3 = "[A-Z]";

        int i=0;
        int j=s.length()-1;

        boolean flag = true;

        while(i<=j) {
            if(!Pattern.matches(pattern, String.valueOf(s.charAt(i)))) {
                i++;
                continue;
            }

            if(!Pattern.matches(pattern, String.valueOf(s.charAt(j)))) {
                j--;
                continue;
            }
            if(s.charAt(i)==s.charAt(j)
                    ||(Pattern.matches(pattern3, String.valueOf(s.charAt(i)))
                    && s.charAt(i)+32 == s.charAt(j))
                    ||(Pattern.matches(pattern2, String.valueOf(s.charAt(i)))
                    && s.charAt(i)-32 == s.charAt(j))) {
                i++;
                j--;
            }else {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
