class Solution {
    public long zeroFilledSubarray(int[] nums) {
        ArrayList<Long> list = new ArrayList<>();
        long count = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == 0)
            {
                count++;
            }
            else
            {
                if(count>0)
                {
                list.add(count);
                }
                count = 0;
            }
        }
        if(count>0)
        {
            list.add(count);
        }
        long ans = 0;
        for(int i=0;i<list.size();i++)
        {
            long n = list.get(i);
            ans+= (n*(n+1))/2;
        }
        return ans;
    }
}