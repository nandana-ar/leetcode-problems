//------------------------------PROBLEM 155------------------------------//
//                               MIN STACK                               //


// Logic:
// -> Use two stacks
//    - One for all elements 
//    - One for tracking minimums
// -> When pushing a new element, push it onto the main stack
//    - If min stack is empty or the new element is less than or equal to
//      the current minimum, also push it onto the min stack
// -> When popping an element, pop it from the main stack
//    - If the popped element is equal to the current minimum,  also pop it 
//      from the min stack
// -> The top of the main stack is the current top element
// -> The top of the min stack is the current minimum element


import java.util.*;

class MinStack {
    private Stack<Integer> stack; 
    private Stack<Integer> minStack; 

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();   
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty())
            return; 
        int top = stack.pop(); 
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int getMin() {
        return minStack.peek();  
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


// Time Complexity:
// -> push: O(1)
// -> pop: O(1)
// -> top: O(1)
// -> getMin: O(1)
// Overall, O(1) for all operations
