class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i=0,j=0;
        int sum=0;
        int ans=0;
        Set<Integer> set = new HashSet<Integer>();
        while(j<nums.length)
        {
            while(set.contains(nums[j]))
            {
                set.remove(nums[i]);
                sum-=nums[i];
                i++;
            }
            sum+=nums[j];
            ans=Math.max(ans,sum);
            set.add(nums[j]);
            j++;
        }
        return ans;
    }
}