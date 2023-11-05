class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for(int i=0;i<s.length();i++)
        {
            last[s.charAt(i)-'a']=i;
        }
        List<Integer> ans = new ArrayList<>();
        int maxIndex=0,start=0;
        for(int i=0;i<s.length();i++)
        {
            maxIndex = Math.max(maxIndex,last[s.charAt(i)-'a']);
            if(i==maxIndex)
            {
                ans.add(i-start+1);
                start=i+1;
            }
        }
        return ans;
    }
}