class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        //HashSet<String> ans = new HashSet<>();
        List<String> ans = new ArrayList<>();
        solve(nums.length,"",ans);
        for(int i=0;i<ans.size();i++)
        {
            if(!set.contains(ans.get(i)))
                return ans.get(i);
        }
        
        /*
        Iterator<String> it = ans.iterator();
        while(it.hasNext()) {
            String str = it.next();
          if(!set.contains(str))
              return str;
        }
        */
        
        return "";
    }
    private void solve(int n, String curr, List<String> ans)
    {
        if(n==0)
        {
            ans.add(curr);
            return;
        }
        solve(n-1,curr+"0",ans);
        solve(n-1,curr+"1",ans);
    }
}