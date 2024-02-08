class Solution {
    public int calculate(String s) {
        return solve(s);
    }
    private int solve(String s)
    {
        Stack<Integer> st = new Stack<>();
        int result=0,sign=1;
        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                int sum=s.charAt(i)-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1)))
                {
                    sum=sum*10+s.charAt(i+1)-'0';
                    i++;
                }
                result = result+sum*sign;
            }
            else if(s.charAt(i)=='+')
            {
                sign=1;
            }
            else if(s.charAt(i)=='-')
            {
                sign=-1;
            }
            else if(s.charAt(i)=='(')
            {
                st.push(result);
                st.push(sign);
                result=0;
                sign=1;
            }
            else if(s.charAt(i)==')')
            {
                result = result*st.pop()+st.pop();//first pop-gives sign, 2nd pop gives num
            }
        }
        return result;
    }
}