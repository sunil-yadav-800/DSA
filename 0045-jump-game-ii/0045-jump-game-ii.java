class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-10);
    int minjump = memoization(0,nums,dp);
    if(minjump==Integer.MAX_VALUE)
    {
        return -1;
    }
    else
    {
        return minjump;
    }
        
    }
    public static int memoization(int ind,int[]arr,int[]dp)
    {
        if(ind>=arr.length-1)
        return 0;
        if(arr[ind]==0)
        return Integer.MAX_VALUE;
        if(dp[ind]!=-10)
        {
            return dp[ind];
        }
        int minjump = Integer.MAX_VALUE;
        for(int i=ind+1;i<=ind+arr[ind] && i<arr.length;i++)
        {
           int jump = memoization(i,arr,dp);
            if(jump != Integer.MAX_VALUE){
                minjump=Math.min(minjump,jump+1);
            }
        }
        return dp[ind] = minjump;
    }
}