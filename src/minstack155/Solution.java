package minstack155;

import java.util.PriorityQueue;
import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Integer min;
    PriorityQueue<Integer> minQ;
    public MinStack() {

        stack = new Stack<>();
        min = null;
        minQ = new PriorityQueue<>();}

    public void push(int val) {

        stack.push(val);
        if(min == null || val < min){
            min = val;
        }
        minQ.add(val);
    }

    public void pop() {

        if(stack.peek().equals(min)){
            minQ.poll();
            min = minQ.peek();
        }
        else {
            minQ.remove(stack.peek());
        }
        stack.pop();
    }

    public int top() {

        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        var x = new MinStack();
        x.push(5);
        x.push(3);
        x.push(4);
        System.out.println(x.getMin());
        x.pop();
        x.pop();
        System.out.println(x.top());
        System.out.println(x.getMin());
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