class Solution {
    public int lengthOfLongestSubstring(String s) {
        //return Longest(s);
        return Solve(s);
        
    }
    public static int Longest(String str)
	{
		int start=0;
		int end=0;
		int maxlen=0;
		int []arr=new int[256];
		while(end<str.length())
		{
			if(arr[str.charAt(end)]==0)
			{
				arr[str.charAt(end)]++;
				end++;
				maxlen=Math.max(end-start, maxlen);
			}
			else
			{
				arr[str.charAt(start)]--;
				start++;
			}
		}
		return maxlen;
	}
    public static int Solve(String str)
    {
        HashSet<Character> set = new HashSet<>();
        int start=0,end=0;
        int ans=0;
        while(end<str.length())
        {
            while(set.contains(str.charAt(end)))
            {
                set.remove(str.charAt(start));
                start++;
            }
            set.add(str.charAt(end));
            end++;
            ans=Math.max(ans,end-start);
        }
        return ans;
    }
}