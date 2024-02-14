class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i=0;i<strs.length+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                for(int k=0;k<n+1;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(strs,0,0,0,m,n,dp);
    }
    private int solve(String[] strs, int idx, int zeros, int ones, int m, int n, int[][][] dp)
    {
        if(zeros==m && ones==n)
        {
            return 0;
        }
        if(idx == strs.length)
        {
            return 0;
        }
        if(dp[idx][zeros][ones]!=-1)
        {
            return dp[idx][zeros][ones];
        }
        int[] arr = count(strs[idx]);
        int take = 0;
        if(arr[0]+zeros<=m && arr[1]+ones<=n)
        {
            take = 1+solve(strs,idx+1,zeros+arr[0],ones+arr[1],m,n,dp); 
        }
        
        int notTake = solve(strs,idx+1,zeros,ones,m,n,dp);
        
        return dp[idx][zeros][ones] = Math.max(take,notTake);
        
    }
    private int[] count(String str)
    {
        int ones=0;
        int zeros=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='0')
            {
                zeros++;
            }
            else
            {
                ones++;
            }
        }
        return new int[]{zeros,ones};
    }
}