class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(k,n,1,0,new ArrayList<>(),ans);
        return ans;
    }
    private void solve(int k, int n, int curr, int sum, List<Integer> list, List<List<Integer>> ans)
    {
        if(k == 0)
        {
            if(sum == n)
            {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(sum > n)
        {
            return;
        }
        for(int i=curr;i<=9;i++)
        {
            list.add(i);
            solve(k-1,n,i+1,sum+i,list,ans);
            list.remove(list.size()-1);
            
        }
    }
}