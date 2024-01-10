class Solution {
    public String decodeString(String s) {
        return Decode(s);
    }
    private String Decode(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=']')
            {
                stack.push(s.charAt(i));
            }
            else
            {
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '[')
                {
                    sb.append(stack.pop());
                }
                stack.pop(); //remeove [
                
                String digits = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                {
                   digits = stack.pop()+digits;
                }
                
                int num = 0;
                if(!digits.equals(""))
                {
                    num = Integer.valueOf(digits);
                }
                sb.reverse();
                StringBuilder sb2 = new StringBuilder();
                for(int j=0;j<num;j++)
                {
                    sb2.append(sb);
                }
                
                for(int j=0;j<sb2.length();j++)
                {
                    stack.push(sb2.charAt(j));
                }
                
            }
        }
        
        StringBuilder ansSb = new StringBuilder();
        while(!stack.isEmpty())
        {
            ansSb.append(stack.pop());
        }
        String ans = ansSb.reverse().toString();
        return ans;
    }
}