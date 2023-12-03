class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        return Tabulation(nums);
    }
    public List<Integer> Tabulation(int[] nums)
    {
        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            dp[i]=1;
            hash[i]=i;
        }
        
        int lastIndex = 0;
        int maxLen = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            for(int prev=0;prev<=i-1;prev++)
            {
                if(nums[i]%nums[prev] == 0 && dp[i]<dp[prev]+1)
                {
                    dp[i]=dp[prev]+1;
                    hash[i]=prev;
                }
            }
            if(maxLen<dp[i])
            {
                maxLen = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex)
        {
            lastIndex = hash[lastIndex];
            ans.add(nums[lastIndex]);
        }
        return ans;
    }
}