class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        int start=0,end=nums.length-1;
        while(start<end)
        {
            int sum = nums[start]+nums[end];
            ans=Math.max(ans,sum);
            start++;
            end--;
        }
        return ans;
    }
}