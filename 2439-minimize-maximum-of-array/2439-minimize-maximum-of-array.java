class Solution {
    public int minimizeArrayValue(int[] nums) {
        double ans=0;
        double sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            double avg = (Math.ceil(sum/(i+1)));
            ans=Math.max(ans,avg);
        }
        return (int)ans;
    }
}