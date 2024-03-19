class Solution {
    public int findMaxLength(int[] nums) {
        //convert all o with -1 and than find longest subarray with 0 sum
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
                nums[i]=-1;
        }
        int ans=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(map.containsKey(sum))
            {
                ans = Math.max(ans,i-map.get(sum));
            }
            else
            {
                map.put(sum,i);
            }
        }
        return ans;
    }
}