class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            if(set.contains(s.charAt(i)))
            {
                ans+=1;
                //clear set
                set = new HashSet<>();
                //add this char to the set because this char will be part of other substring
                set.add(s.charAt(i));
            }
            else
            {
                set.add(s.charAt(i));
            }
        }
        //return ans+1 because last substing also need to count
        return ans+1;
    }
}