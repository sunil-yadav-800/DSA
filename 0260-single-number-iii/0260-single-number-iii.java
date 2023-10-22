class Solution {
    public int[] singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            res=res^nums[i];
        }
        int num1=0;
        int num2=0;
        int setBit = res & ~(res-1);
        for(int i=0;i<nums.length;i++)
        {
            if((nums[i] & setBit) == 0)
            {
                num1=num1^nums[i];
            }
            else
            {
                num2=num2^nums[i];
            }
        }
        return new int[]{num1,num2};
    }
}