class Solution {
    public boolean isValid(String s) {
        return isValidParentheses(s);
    }
    public boolean isValidParentheses(String str)
    {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch =='(' || ch =='{' ||ch =='[')
            {
                st.push(ch);
            }
            else
            {
                if(st.isEmpty())
                {
                    return false;
                }
                char top = st.peek();
                if((top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']'))
                {
                    st.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}