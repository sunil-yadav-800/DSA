class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            int cnt=0;
            int sum=0;
            for(int j=1;j*j<=nums[i];j++)
            {
                if(nums[i]%j==0)
                {
                    cnt++;
                    sum+=j;
                    if(j*j != nums[i])
                    {
                        cnt++;
                        sum+=nums[i]/j;
                    }
                }
            }
            if(cnt==4)
            {
                ans+=sum;
            }
        }
        return ans;
    }
}