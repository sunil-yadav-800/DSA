class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for(int i=0;i<nums.length;i++)
        {
            maxIndex = Math.max(nums[i]+i,maxIndex);
            if(maxIndex>=nums.length-1)
                return true;
            if(i>=maxIndex)
                return false;
        }
        return true;
    }
}