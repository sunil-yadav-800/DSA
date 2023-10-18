class Solution {
    public int removeDuplicates(int[] nums) {
        int index=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[index])
            {
                if(index>=1)
                {
                    if(nums[index-1]==nums[i])
                    {
                        continue;
                    }
                    else
                    {
                        nums[++index]=nums[i];
                    }
                }
                else
                {
                    nums[++index]=nums[i];
                }
            }
            else
            {
                nums[++index]=nums[i];
            }
        }
        return index+1;
    }
}