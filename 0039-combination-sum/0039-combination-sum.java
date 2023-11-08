class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Solve(candidates,0,target,ans,list);
        return ans;
    }
    private void Solve(int[] arr, int idx, int target, List<List<Integer>> ans, List<Integer> list)
    {
        if(idx == arr.length)
        {
            if(target == 0)
            {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        //include
        if(target-arr[idx]>=0)
        {
        list.add(arr[idx]);
        Solve(arr,idx,target-arr[idx],ans,list);
        list.remove(list.size()-1);
        }
        
        // don't include
        Solve(arr,idx+1,target,ans,list);
    }
}