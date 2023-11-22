class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        solve(s,0,"",ans);
        return ans;
    }
    private void solve(String s, int idx, String curr, List<String> ans)
    {
        if(idx == s.length())
        {
            ans.add(curr);
            return;
        }
        char ch = s.charAt(idx);
        solve(s,idx+1,curr+ch,ans);
        if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z'))
        {
            if(ch>='A' && ch<='Z')
            {
                ch=(char)(ch+32);
                solve(s,idx+1,curr+ch,ans);
            }
            else
            {
                ch=(char)(ch-32);
                solve(s,idx+1,curr+ch,ans);
            }
        }
    }
}