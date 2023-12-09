class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int left1=0; //for  map1
        int left2=0; //for map2
        int ans=0;
        for(int right=0;right<nums.length;right++)
        {
            map1.put(nums[right],map1.getOrDefault(nums[right],0)+1);
            map2.put(nums[right],map2.getOrDefault(nums[right],0)+1);
            while(map1.size() > k)
            {
                map1.put(nums[left1],map1.get(nums[left1])-1);
                if(map1.get(nums[left1]) == 0)
                {
                    map1.remove(nums[left1]);
                }
                left1++;
            }
            while(map2.size() >= k)
            {
                map2.put(nums[left2],map2.get(nums[left2])-1);
                if(map2.get(nums[left2]) == 0)
                {
                    map2.remove(nums[left2]);
                }
                left2++;
            }
            
            ans+=left2-left1;
        }
        return ans;
    }
}