class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        Stack<Integer> st = new Stack<>();
        //find previous smaller
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            int index=st.isEmpty()?0:st.peek()+1;
            prevSmaller[i]=index;
            st.push(i);
        }
        //clear the stack
        st = new Stack<>();
        // find next smaller
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            int index=st.isEmpty()?n-1:st.peek()-1;
            nextSmaller[i]=index;
            st.push(i);
        }
        //calculate max area
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            ans = Math.max(ans,(nextSmaller[i]-prevSmaller[i]+1)*heights[i]);
        }
        return ans;
        
    }
}