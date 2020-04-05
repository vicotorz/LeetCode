/**
 * leetcode-151
 * */

public class Reverse_Words_in_a_String {

    public String reverseWords(String s) {

        if(s==null||s.equals("")||s.length()==0) {
            return s;
        }

        //先整体翻转，然后针对各个单词进行翻转
        StringBuffer result = new StringBuffer();

        String[] strArray = reverseStr(s).split(" ");

        for(String tmpStr:strArray) {
            //System.out.println(tmpStr+"--"+tmpStr.equals(""));
            if(tmpStr.equals("")) {
                continue;
            }else {
                result.append(reverseStr(tmpStr));
                result.append(" ");
            }
        }

        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    public static String reverseStr(String str) {
        StringBuffer result = new StringBuffer();

        for (int i = str.length() - 1; i >= 0; i--) {
            result.append(str.charAt(i));
        }

        return result.toString();
    }
}
