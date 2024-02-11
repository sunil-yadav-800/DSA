class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return scs(str1,str2);
    }
    public String scs(String str1, String str2)
    {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        //base case is already filled
        
        for(int i=1;i<=str1.length();i++)
        {
            for(int j=1;j<=str2.length();j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int row=dp.length-1;
        int col=dp[0].length-1;
        StringBuilder sb = new StringBuilder();
        while(row>0 && col>0)
        {
            if(str1.charAt(row-1)==str2.charAt(col-1))
            {
                sb.append(str1.charAt(row-1));
                row--;
                col--;
            }
            else if(dp[row-1][col]>dp[row][col-1])
            {
                sb.append(str1.charAt(row-1));
                row--;
            }
            else
            {
                sb.append(str2.charAt(col-1));
                col--;
            }
        }
        while(row>0)
        {
           sb.append(str1.charAt(row-1));
           row--; 
        }
        while(col>0)
        {
            sb.append(str2.charAt(col-1));
            col--;
        }
        return sb.reverse().toString();
    }
}