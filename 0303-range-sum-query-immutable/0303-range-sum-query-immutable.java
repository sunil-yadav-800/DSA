class NumArray {
int[] sumArray;
    public NumArray(int[] nums) {
        sumArray = new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            sumArray[i]=sum;
        }
    }
    
    public int sumRange(int left, int right) {
        int sum=sumArray[right];
        if(left>0)
            sum-=sumArray[left-1];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */