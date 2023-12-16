class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<num.length();i++)
        {
            if(k>0)
            {
                while(k>0 && !st.isEmpty() && st.peek()>num.charAt(i))
                {
                    st.pop();
                    k--;
                }
                st.push(num.charAt(i));
            }
            else
            {
                st.push(num.charAt(i));
            }
        }
        //if still k>0
        while(k>0 && !st.isEmpty())
        {
            st.pop();
            k--;
        }
        
        if(st.isEmpty())
        {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        int lastIndex = sb.length()-1;
        while(lastIndex>0 && sb.charAt(lastIndex) == '0')
        {
            lastIndex--;
        }
        
        StringBuilder ans = new StringBuilder(sb.substring(0,lastIndex+1));
        
        return ans.reverse().toString();
    }
}