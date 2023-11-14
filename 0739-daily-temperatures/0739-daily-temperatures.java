class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.empty() && temperatures[i]>=temperatures[st.peek()])
            {
                st.pop();
            }
            int value = st.empty()?0:(st.peek()-i);
            ans[i]=value;
            st.push(i);
        }
        return ans;
    }
}