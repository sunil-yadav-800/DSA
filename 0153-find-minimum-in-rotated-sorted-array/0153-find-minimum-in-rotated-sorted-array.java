class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        if(nums.length == 1 || nums[0]<=nums[high])
            return nums[0];
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(nums[mid]>=nums[mid+1])
                return nums[mid+1];
            else if(nums[low]<=nums[mid])
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
}