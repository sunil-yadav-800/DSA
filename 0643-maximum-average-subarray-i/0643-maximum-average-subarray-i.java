class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = 0;
        double sum=0;
        int i=0;
        while(i<k)
        {
            sum+=nums[i];
            i++;
        }
        ans=sum/k;
        for(;i<nums.length;i++)
        {
            sum+=-nums[i-k]+nums[i];
            ans=Math.max(ans,sum/k);
        }
        return ans;
    }
}