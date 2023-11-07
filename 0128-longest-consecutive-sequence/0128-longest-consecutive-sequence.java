class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
       HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        int ans=1;
        for(int i=0;i<nums.length;i++)
        {
            if(!set.contains(nums[i]-1))
            {
                int count=1;
                int num=nums[i]+1;
                while(set.contains(num))
                {
                    count++;
                    num++;
                }
                ans=Math.max(ans,count);
            }
            
        }
        return ans;
        
    }
}