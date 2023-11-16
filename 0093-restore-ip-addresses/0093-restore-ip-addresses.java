class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        solve(s,0,"",ans);
        return ans;
    }
    private void solve(String s, int dots, String curr, List<String> ans)
    {
        if(s.length() == 0)
        {
            if(dots == 4)
            {
                ans.add(curr.substring(0,curr.length()-1));
            }
            return;
        }
        for(int i=1;i<=Math.min(3,s.length());i++)
        {
            String str = s.substring(0,i);
            int value = Integer.valueOf(str);
            String next = s.substring(i);
            if((str.length()==1 || str.charAt(0)!='0') && value<=255)
            {
                solve(next,dots+1,curr+str+".",ans);
            }
        }
    }
}