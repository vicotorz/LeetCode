import java.util.Stack;

/**
 * LeetCode-155
 */
public class Min_Stack {
    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack();//commonStack
    Stack<Integer> minStack = new Stack();//min Stack

    public Min_Stack() {

    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()||x<=minStack.peek()) {
            minStack.add(x);
        }else {
            minStack.add(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
