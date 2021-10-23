package edu.interview_bit.stacks_and_queues;

import java.util.Stack;

public class MinStack_II {

    Stack<Integer> stack;
    int min = 0;

    public MinStack_II() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            min = val;
        } else if (val < min) {
            stack.push((val + val - min));
            min = val;
        } else {
            stack.push(val);
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }

        if (stack.peek() < min) {
            return min;
        }
        return stack.peek();
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int val = stack.pop();
        if (val < min) {
            int oldMin = min;
            min = 2 * min - val;
            val = oldMin;
        }
        if (stack.isEmpty()) {
            min = -1;
        }
        return val;
    }

    public int size() {
        return stack.size();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack_II minStack_ii = new MinStack_II();

//        int[] arr = {15, 17, 19, 9, 10, 7};
        int[] arr = {5, 4, 7, 9, -2, -5};

        for (int i = 0; i < arr.length; i++) {
            minStack_ii.push(arr[i]);
            System.out.println("Push: " + minStack_ii.top());
            System.out.println("Min: " + minStack_ii.getMin());
            System.out.println();
        }

        System.out.println("---------------------------");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Pop: " + minStack_ii.pop());
            System.out.println("Min: " + minStack_ii.getMin());
            System.out.println();
        }
    }
}
