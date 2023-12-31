class Solution {
    public String removeStars(String s) {
        return Approach1(s);
    }
    public String Approach1(String s)
    {
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='*')
            {
                st.pop();
            }
            else
            {
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}