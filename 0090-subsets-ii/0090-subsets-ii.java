class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Solve(nums,0,ans,list);
        return ans;
    }
    private void Solve(int[] arr, int idx, List<List<Integer>> ans, List<Integer> list)
    {
        ans.add(new ArrayList<>(list));
        for(int i=idx;i<arr.length;i++)
        {
            if(i>idx && arr[i]==arr[i-1])
                continue;
            list.add(arr[i]);
            Solve(arr,i+1,ans,list);
            list.remove(list.size()-1);
        }
    }
}