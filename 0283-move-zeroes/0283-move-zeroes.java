class Solution {
    public void moveZeroes(int[] nums) {
     int ZeroIndex=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                nums[ZeroIndex]=nums[i];
                ZeroIndex++;
            }
        }
        for(int i=ZeroIndex;i<nums.length;i++)
        {
            nums[i]=0;
        }
    }
}