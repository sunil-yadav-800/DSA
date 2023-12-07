class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int flip=0;
        int ans=-1;
        while(j<nums.length)
        {
            if(flip == k && nums[j]==0)
            {
                while(i<=j && flip == k)
                {
                    if(nums[i]==0)
                    {
                        flip--;
                    }
                    i++;
                }
            }
            if(nums[j]==0)
            {
                flip++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}