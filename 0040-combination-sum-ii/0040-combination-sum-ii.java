class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Solve(candidates,0,target,ans,list);
        return ans;
    }
    private void Solve(int[] arr, int idx, int target, List<List<Integer>> ans, List<Integer> list)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(list));
        }
        for(int i=idx;i<arr.length;i++)
        {
            //exclude duplicate sets
            if(i>idx && arr[i]==arr[i-1])
                continue;
            if(target-arr[i]>=0)
            {
            list.add(arr[i]);
            Solve(arr,i+1,target-arr[i],ans,list);
            list.remove(list.size()-1);
            }
            
        }
    }
}