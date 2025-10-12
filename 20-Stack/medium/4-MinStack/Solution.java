
import java.util.Stack;

class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {

        if (stackMin.isEmpty() || stackMin.peek() >= val) {
            stackMin.push(val);
        }

        stack.push(val);
    }

    public void pop() {
        if (stackMin.peek().equals(stack.peek())) {
            stackMin.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */