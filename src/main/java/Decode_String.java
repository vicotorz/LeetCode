import java.util.Stack;

/**
 * LeetCode-394
 */
public class Decode_String {
    public String decodeString(String s) {
        if(s.equals("")||s==null) {
            return new String();
        }

        Stack<String> stack = new Stack();
        //处理一个完整的数字[字符]
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                // 弹出stack中的数，处理后压入
                String tmp = new String();
                while (!stack.peek().equals("[")) {
                    tmp = stack.pop() + tmp;
                }

                stack.pop();//弹出[

                //数字可能10位数以上
                String num = new String();
                while(!stack.isEmpty() && stack.peek().matches("^[0-9]$")) {
                    num = stack.pop()+num;
                }

                String tmpLong = new String();
                for (int j = 1; j <= Integer.valueOf(num); j++) {
                    tmpLong = tmpLong + tmp;
                }
                stack.push(tmpLong);
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }

        StringBuffer resString = new StringBuffer("");

        while (!stack.isEmpty()) {
            resString.insert(0, stack.pop());

        }
        return resString.toString();
    }
}
