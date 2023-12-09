class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            
        }
        int ans=0;
        for(Map.Entry<Integer,Integer> itr : map.entrySet())
        {
            if(k == 0)
            {
                System.out.print("key: "+itr.getKey());
                System.out.println(" value: "+itr.getValue());
                if(itr.getValue()>1)
                    ans++;
            }
            else
            {
                if(map.containsKey(k+itr.getKey()))
                    ans++;
            }
        }
        return ans;
    }
}