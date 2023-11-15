class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            int low=i+1;
            int high=nums.length-1;
            while(low<high)
            {
                int sum = nums[i]+nums[low]+nums[high];
                if( sum == target)
                    return target;
                if(Math.abs(sum-target)<diff)
                {
                    ans=sum;
                    diff=Math.abs(sum-target);
                }
                if(sum<target)
                {
                    low++;
                }
                else
                {
                    high--;
                }
            }
        }
        return ans;
    }
}