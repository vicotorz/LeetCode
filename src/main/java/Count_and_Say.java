/**
 * LeetCode-38
 */
public class Count_and_Say {
    public String countAndSay(int n) {
        String res = "1";
        for(int i=1;i<n;i++) {
            res=generateNum(res);
        }
        return res;
    }

    public static String generateNum(String num) {
        StringBuffer sb = new StringBuffer();
        int count=1;
        String preNum =null;
        //找到一个数字的时候一定要看后面有没有一样的数字
        for (int i = 0; i < num.length();i++) {
            if(preNum==null) {
                preNum = String.valueOf(num.charAt(i));
            }else {
                if(String.valueOf(num.charAt(i)).equals(preNum)) {
                    count++;
                }else {
                    sb.append(count);
                    sb.append(preNum);
                    preNum=String.valueOf(num.charAt(i));
                    count=1;
                }
            }

        }
        sb.append(count);
        sb.append(preNum);
        return sb.toString();
    }
}
