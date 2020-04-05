import java.util.ArrayList;
import java.util.List;
/**
 * LeetCode-93
 */
public class Restore_IP_Addresses {

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.isEmpty() || s.length() == 0 || s.length() >= 13) {
            return new ArrayList();
        }

        List<String> result = new ArrayList();

        getDepthIPAddr(s, 0, s.length() - 1, result, new ArrayList());

        return result;
    }


    public static String getCombinationStr(List<String> list) {
        StringBuffer resStr = new StringBuffer();

        resStr.append(list.get(0));
        resStr.append(list.get(1));
        resStr.append(list.get(2));
        resStr.append(list.get(3).substring(0, list.get(3).length() - 1));

        return resStr.toString();
    }

    public static void getDepthIPAddr(String s, int start, int end, List<String> result, List<String> list) {

        if (start > end && list.size() == 4) {
            // System.out.println("[1]");
            // System.out.println("==============");
            // System.out.println(list.toString());
            String resStr = getCombinationStr(list);
            // System.out.println(resStr);
            result.add(resStr);
            // list.clear();
            return;
        }

        // System.out.println(start + "-----" + end + "----剩下--" + s.substring(start,
        // end + 1));
        for (int i = start; i <= end; i++) {
            String str = s.substring(start, i + 1);
            // System.out.println(str);
            if (isIPDigit(str)) {
                // System.out.println(str + "符合");
                list.add(str + ".");
                getDepthIPAddr(s, i + 1, end, result, list);
                // System.out.println(list.size() + "-----" + list.toString());
                list.remove(list.size() - 1);

            } else {
                return;
            }
        }
    }

    public static boolean isIPDigit(String str) {
        if (str.equals("")) {
            return false;
        }
        int num = Integer.valueOf(str);
        // 00 0d
        String pattern = "(0)+[0-9]+";
        boolean isMatch = str.matches(pattern);
        return (num >= 0 && num <= 255 && (!isMatch)) ? true : false;
    }
}
