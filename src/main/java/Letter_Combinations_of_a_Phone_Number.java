import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode-17
 */
public class Letter_Combinations_of_a_Phone_Number {
    public HashMap<String, String> map;

    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) {
            return new ArrayList<String>();
        }
        map = new HashMap();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        ArrayList list = new ArrayList();
        letterCombina("",list,digits);
        return list;
    }


    public  void letterCombina(String res,ArrayList result,String digits) {
        if(digits.length()==0) {
            result.add(res);
            return;
        }

        String digit=digits.substring(0,1);
        String words=map.get(digit);
        for(int i=0;i<words.length();i++) {
            letterCombina(res + words.substring(i, i+1),result,digits.substring(1));
        }
    }
}
