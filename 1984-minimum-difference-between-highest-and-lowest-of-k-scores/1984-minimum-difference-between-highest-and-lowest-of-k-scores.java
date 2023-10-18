class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k==1)
            return 0;
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        int start=0, end=k-1;
        while(end<nums.length)
        {
            ans=Math.min(ans,nums[end]-nums[start]);
            start++;
            end++;
        }
        return ans;
    }
}