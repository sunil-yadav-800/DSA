class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prev[]=new int[nums.length+1];
        int next[]=new int[nums.length+1];
        int ans[]=new int[nums.length];
        prev[0]=1;
        for(int i=1;i<prev.length;i++)
        {
            prev[i]=prev[i-1]*nums[i-1];
        }
        next[next.length-1]=1;
        for(int i=next.length-2;i>=0;i--)
        {
            next[i]=next[i+1]*nums[i];
        }
        
        for(int i=0;i<nums.length;i++)
        {
            ans[i]=prev[i]*next[i+1];
        }
        
        return ans;
        
    }
}