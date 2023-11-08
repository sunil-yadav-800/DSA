class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Solve(nums,0,ans,list);
        return ans;
    }
    private void Solve(int[] nums, int idx, List<List<Integer>> ans, List<Integer> list)
    {
        //base case
        if(idx == nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        //don't include
        Solve(nums,idx+1,ans,list);
        
        //include
        list.add(nums[idx]);
        Solve(nums,idx+1,ans,list);
        list.remove(list.size()-1);
        
    }
}