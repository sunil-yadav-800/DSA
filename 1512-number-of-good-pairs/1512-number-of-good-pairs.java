class Solution {
    public int numIdenticalPairs(int[] nums) {
        //return Approach1(nums);
        return Approach2(nums);
    }
    public int Approach1(int[] nums)
    {
        int pairs=0;
        
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                    pairs++;
                }
            }
        }
        return pairs;
    }
    public int Approach2(int[] nums)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                count+=map.get(nums[i]);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
}