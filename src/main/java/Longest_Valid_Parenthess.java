import java.util.Stack;

/**
 * LeetCode-32
 */
public class Longest_Valid_Parenthess {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack();
        int Max = 0;
        stack.push(-1);//防止第一个值为‘（’,一定为-1
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                stack.push(i);
            }else {
                stack.pop();//如果栈中第一个元素是‘（’，直接弹出，配对成功
                if(stack.isEmpty()) {
                    stack.push(i);
                }else {
                    Max=Math.max(Max, i-stack.peek());
                }
            }
        }
        return Max;
    }
}
