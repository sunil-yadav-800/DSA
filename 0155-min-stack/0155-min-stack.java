class Pair{
    int val;
    int minSoFar;
    public Pair(int value, int min)
    {
        val=value;
        minSoFar=min;
    }
}
class MinStack {
    Stack<Pair> st = new Stack<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        min = Math.min(min,val);
        st.push(new Pair(val,min));
    }
    
    public void pop() {
        Pair p = st.pop();
        if(!st.isEmpty()){
        min=st.peek().minSoFar;
        }
        else
        {
            min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        Pair p = st.peek();
        return p.val;
    }
    
    public int getMin() {
        Pair p = st.peek();
        return p.minSoFar;
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