class MyQueue {
    private Stack<Integer> stack;
    public MyQueue() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        stack.push(x);
        st2.push(stack.pop());
        while(!stack.isEmpty()){
            st1.push(stack.pop());
        }
        stack.push(st2.peek());
        while(!st1.isEmpty()){
            stack.push(st1.pop());
        }
    }
    
    public int pop() {
        int data = stack.peek();
        stack.pop();
        return data;
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */