class Solution {
    public void sortColors(int[] nums) {
        
        int start=0,end=nums.length-1,mid=0;
        while(mid<=end)
        {
            if(nums[mid]==0)
            {
                int temp=nums[start];
                nums[start]=nums[mid];
                nums[mid]=temp;
                start++;
                mid++;
            }
            else if(nums[mid]==1)
            {
                mid++;
            }
            else
            {
               int temp=nums[end];
                nums[end]=nums[mid];
                nums[mid]=temp;
                end--;
                
            }
        }
        
    }
}