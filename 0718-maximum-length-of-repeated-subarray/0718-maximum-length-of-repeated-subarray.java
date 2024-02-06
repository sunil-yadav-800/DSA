class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        return solve(nums1,nums2);
    }
    private int solve(int[] nums1, int[] nums2)
    {
        int ans=0;
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        //base case;
        for(int i=0;i<dp[0].length;i++)
        {
            dp[0][i]=0;
        }
        for(int i=0;i<dp.length;i++)
        {
            dp[i][0]=0;
        }
        
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(nums1[i-1]==nums2[j-1])
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=0;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}