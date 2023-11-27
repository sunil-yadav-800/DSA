class Solution {
    public int calPoints(String[] operations) {
        return calculate(operations);
    }
    public int calculate(String[] oper)
    {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<oper.length;i++)
        {
            String str  = oper[i];
            if(str.equals("+"))
            {
                int top1 = st.pop();
                int top2 = st.pop();
                int sum = top1+top2;
                st.push(top2);
                st.push(top1);
                st.push(sum);
            }
            else if(str.equals("D"))
            {
                int top = st.peek();
                st.push(2*top);
            }
            else if(str.equals("C"))
            {
                st.pop();
            }
            else
            {
                st.push(Integer.parseInt(str));
            }
        }
       int totalSum=0;
        while(!st.isEmpty())
        {
            totalSum+=st.pop();
        }
        return totalSum;
    }
}