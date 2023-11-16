class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n,"",0,0,ans);
        return ans;
    }
    private void solve(int n, String curr, int open, int close, List<String> ans)
    {
        if(open == n && close == n)
        {
            ans.add(curr);
            return;
        }
        if(open>n || close>n || close>open)
            return; 
        
        solve(n,curr+"(",open+1,close,ans);
        solve(n,curr+")",open,close+1,ans);
    }
}