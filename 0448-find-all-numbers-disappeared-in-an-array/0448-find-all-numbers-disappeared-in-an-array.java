class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       
        List<Integer> ans= new ArrayList<>();
        
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums)
        {
            set.add(num);
        }
        int k=1;
        while(k<=nums.length)
        {
            if(!set.contains(k))
            {
                ans.add(k);
            }
            k++;
        }
        return ans;
    }
}