class Solution {
    public int[] sortArray(int[] nums) {
        HeapSort(nums);
        return nums;
    }
    private void HeapSort(int[] nums)
    {
        int n = nums.length;
        for(int i=n/2-1;i>=0;i--)
        {
            maxHeapify(nums,n,i);
        }
        
        for(int i=n-1;i>=0;i--)
        {
            int temp=nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
            maxHeapify(nums,i,0);
        }
    }
    private void maxHeapify(int[] nums, int size, int i)
    {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        
        if(left<size && nums[left]>=nums[largest])
        {
            largest = left;
        }
        if(right<size && nums[right]>nums[largest])
        {
            largest = right;
        }
        if(largest!=i)
        {
            int temp=nums[i];
            nums[i]=nums[largest];
            nums[largest]=temp;
            maxHeapify(nums,size,largest);
        }
    }
}