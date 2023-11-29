class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int low=0,high=0;
        while(high<nums.length)
        {
            if(nums[high]%2==0)
            {
                int temp=nums[low];
                nums[low]=nums[high];
                nums[high]=temp;
                low++;
                high++;
            }
            else
            {
                high++;
            }
        }
        return nums;
    }
}