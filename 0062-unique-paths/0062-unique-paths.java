class Solution {
    public int uniquePaths(int m, int n) {
        
       // return Approach2(m,n);
        //return Approach1(m,n);
        
        return Table(m,n);
    }
    public static int Approach1(int m, int n)
    {
        long ans=1;
        for(int i=1;i<m;i++)
        {
            ans=ans*(n-1+i)/i;
        }
        return (int)ans;
    }
    public static int Approach2(int m, int n)
    {
        int[][]dp=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return unique(m,n,0,0,dp);
    }
    public static int unique(int m,int n,int row,int col,int[][]dp)
    {
        if(row==m-1 && col==n-1)
        {
            return 1;
        }
        if(row==m || col==n)
        {
            return 0;
        }
        if(dp[row][col]!=-1)
        {
            return dp[row][col];
        }
        int right=unique(m,n,row,col+1,dp);
        int down=unique(m,n,row+1,col,dp);
        return dp[row][col]=right+down;
    }
    private static int Table(int m, int n)
    {
        int[][]dp=new int[m+1][n+1];
        //base case
        dp[m-1][n-1]=1;
        //2nd base case handled already
        
        for(int row=m-1;row>=0;row--)
        {
            for(int col=n-1;col>=0;col--)
            {
                if(row == m-1 && col== n-1)
                {
                    continue;
                }
                int right=dp[row][col+1];
                int down=dp[row+1][col];
                dp[row][col]=right+down;
            }
        }
        return dp[0][0];
    }
}