class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<nums.length)
        {
            int j=i;
            while(j+1<nums.length && nums[j+1]==nums[j]+1)
            {
                j++;
            }
            if(i==j)
            {
                ans.add(String.valueOf(nums[i]));
                i++;
            }
            else
            {
                String str = String.valueOf(nums[i])+"->"+String.valueOf(nums[j]);
                ans.add(str);
                i=j+1;
            }
            
        }
        return ans;
    }
}