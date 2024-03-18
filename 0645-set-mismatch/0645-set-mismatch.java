class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        //find no. that occurs twice
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!set.contains(nums[i]))
            {
                set.add(nums[i]);
            }
            else
            {
                ans[0]=nums[i];
            }
        }
        
        //find no. which is missing
        int n=1;
        while(n<=nums.length)
        {
            if(!set.contains(n))
            {
                ans[1]=n;
                break;
            }
            n++;
        }
        
        return ans;
    }
}