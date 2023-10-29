class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2))
            return "0";
        num1 = reverse(num1);
        num2 = reverse(num2);
        int[] res = new int[num1.length()+num2.length()];
        for(int i=0;i<num1.length();i++)
        {
            for(int j=0;j<num2.length();j++)
            {
                int prod = Integer.valueOf(String.valueOf(num1.charAt(i)))*Integer.valueOf(String.valueOf(num2.charAt(j)));
                int value = res[i+j]+prod;
                res[i+j]=value%10;
                res[i+j+1]+=value/10;
                
            }
        }
        StringBuilder sb = new StringBuilder();
        int endIndex = res.length-1;
        while(endIndex>=0 && res[endIndex]==0)
        {
            endIndex--;
        }
        for(int i=endIndex;i>=0;i--)
        {
            sb.append(res[i]);
        }
        return sb.toString();
        
    }
    private String reverse(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}