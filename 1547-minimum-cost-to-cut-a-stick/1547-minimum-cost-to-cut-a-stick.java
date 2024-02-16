class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] arr = new int[cuts.length+2];
        arr[0]=0;
        for(int i=1;i<=cuts.length;i++)
        {
            arr[i]=cuts[i-1];
        }
        arr[cuts.length+1]=n;
        int[][] dp = new int[cuts.length+2][cuts.length+2];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(arr,1,cuts.length,dp);
    }
    private int solve(int[] arr, int i, int j, int[][] dp)
    {
        if(i>j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++)
        {
            int cost = arr[j+1]-arr[i-1]+solve(arr,i,ind-1,dp)+solve(arr,ind+1,j,dp);
            ans=Math.min(ans,cost);
        }
        return dp[i][j] = ans;
    }
}