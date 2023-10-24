class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int first=0;
        for(int snd=0;snd<nums.length;snd++)
        {
            if(set.size()>k)
            {
                set.remove(nums[first]);
                first++;
            }
            if(set.contains(nums[snd]))
                return true;
            set.add(nums[snd]);
        }
        return false;
    }
}