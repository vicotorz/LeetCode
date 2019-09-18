import java.util.HashMap;

/**
 * LeetCode-12
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        int length = String.valueOf(num).toCharArray().length;
        StringBuffer result = new StringBuffer();
        for (int i = length; i >= 1; i--) {
            int chu = (int) (num / Math.pow(10, i - 1));
            int yu = (int) (num % Math.pow(10, i - 1));
            num = yu;
            result.append(getStr(chu, (int) Math.pow(10, i - 1)));
        }
        return result.toString();
    }

    public String getStr(int num, int bit) {
        HashMap<Integer, String> map = new HashMap();
        map.put(0, "");
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        HashMap<Integer, String> addmap = new HashMap<>();
        addmap.put(0, "0");
        addmap.put(1, "1");
        addmap.put(2, "1,1");
        addmap.put(3, "1,1,1");
        addmap.put(4, "1,5");
        addmap.put(5, "5");
        addmap.put(6, "5,1");
        addmap.put(7, "5,1,1");
        addmap.put(8, "5,1,1,1");
        addmap.put(9, "1,10");
        addmap.put(10, "10");

        // 获得构成
        String[] str = addmap.get(num).split(",");
        // 获得字符串
        StringBuffer StrNum = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            String s = map.get(Integer.valueOf(str[i]) * bit);
            StrNum.append(s);
        }
        return StrNum.toString();
    }
}
