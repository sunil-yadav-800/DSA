class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Solve(s,ans,list);
        return ans;
    }
    private void Solve(String s, List<List<String>> ans, List<String> list)
    {
        if(s.length() == 0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=1;i<=s.length();i++)
        {
            String curr = s.substring(0,i);
            if(palindrome(curr))
            {
                String remain = s.substring(i);
                list.add(curr);
                Solve(remain,ans,list);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean palindrome(String s)
    {
        int start=0,end=s.length()-1;
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}