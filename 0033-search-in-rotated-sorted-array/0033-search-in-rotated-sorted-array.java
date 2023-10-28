class Solution {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            //if mid is target
            if(nums[mid] == target)
            {
                return mid;
            }
            //if first part is sorted
            else if(nums[low] <= nums[mid])
            {
                //if target lies in sorted part
                if(nums[low]<= target && target<=nums[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            //another part is sorted
            else
            {
                //target lies in sorted part
                if(nums[mid]<=target && target<= nums[high])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}