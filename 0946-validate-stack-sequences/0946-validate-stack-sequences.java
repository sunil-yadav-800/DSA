class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<Integer>();
        int popIndex=0;
        for(int i=0;i<pushed.length;i++)
        {
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek() == popped[popIndex])
            {
                st.pop();
                popIndex++;
            }
        }
        while(popIndex<popped.length)
        {
            if(!st.isEmpty() && st.peek() == popped[popIndex])
            {
              st.pop();  
              popIndex++;
            }
            else
            {
                return false;
            }
        }
        return st.isEmpty();
    }
}