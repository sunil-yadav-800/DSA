class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for(int i=0;i<nums.length-1;i++)
        {
            maxIndex = Math.max(nums[i]+i,maxIndex);
            if(i>=maxIndex)
                return false;
        }
        return true;
    }
}