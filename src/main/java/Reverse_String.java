/**
 * LeetCode-344
 */
public class Reverse_String {
    public void reverseString(char[] s) {
        if(s==null||s.length==0) {
            return;
        }
        int i=0;
        int j=s.length-1;
        while(i<j) {
            char tmp = s[i];
            s[i]=s[j];
            s[j]=tmp;
            i++;
            j--;
        }
    }
}
