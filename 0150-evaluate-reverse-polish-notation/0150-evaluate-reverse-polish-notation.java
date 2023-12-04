class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<tokens.length;i++)
        {
           if(isOperator(tokens[i]))
           {
               int top1 = stack.pop();
               int top2 = stack.pop();
               int result = operation(top1,top2,tokens[i]);
               stack.push(result);
           }
           else
           {
               stack.push(Integer.parseInt(tokens[i]));
           }
        }
        return stack.peek();
    }
    public boolean isOperator(String str)
    {
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
        {
          return true;
        }
        return false;
    }
    public int operation(int top1, int top2, String oper)
    {
        if(oper.equals("+"))
            return top1+top2;
        else if(oper.equals("-"))
            return top2-top1;
        else if(oper.equals("*"))
            return top1*top2;
        else
            return top2/top1;
    }
}