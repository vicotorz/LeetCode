/**
 * LeetCode-5
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0) {
            return s;
        }

        //Manacher算法
        String[] str = new String[s.length() * 2 + 1];
        int[] length = new int[s.length() * 2 + 1];
        str[0] = "#";
        int j = 1;
        for (int i = 0; i < s.length(); i++) {
            str[j] = String.valueOf(s.charAt(i));
            str[j + 1] = "#";
            j=j+2;
        }

        // calculate
        int maxLength=0;
        for(int i=0;i<str.length;i++) {//以i为中心，计算两侧字符是否一直
            int k1=i-1;
            int k2=i+1;
            while(k1>=0 && k2<str.length) {
                if(str[k1].equals(str[k2])) {
                    length[i]++;
                    k1=k1-1;
                    k2=k2+1;
                    maxLength=Math.max(maxLength,length[i]);
                }else {
                    break;
                }
            }
        }
        //重新确定最大值的位置
        int maxLoc=0;
        for(int loc=0;loc<length.length;loc++) {
            if(length[loc]==maxLength) {
                maxLoc = loc;
                break;
            }
        }
        String res = new String(str[maxLoc].equals("#")?"":str[maxLoc]);
        for(int step=1;step<=maxLength;step++) {
            if(!str[maxLoc-step].equals("#")) {
                res = str[maxLoc-step]+res+str[maxLoc-step];
            }
        }
        return res;
    }
}
