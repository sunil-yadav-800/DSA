class Solution {
    public int triangleNumber(int[] nums) {
        int ans=0;
        Arrays.sort(nums);
        for(int i=2;i<nums.length;i++)
        {
            int j=0,k=i-1;
            while(j<k)
            {
                if(nums[j]+nums[k]>nums[i])
                {
                    ans+=k-j;
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }
        return ans;
    }
}

//triangle means:- sum of two sides must be greater than the third side in all cases