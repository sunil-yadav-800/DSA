class Solution {
    public String lastNonEmptyString(String s) {
        return solve(s);
    }
    private String BruteForce(String s)
    {
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        while(true)
        {
            
            int i=0;
            while(i<sb1.length())
            {
                if(set.contains(sb1.charAt(i)))
                {
                    sb2.append(sb1.charAt(i));
                }
                set.add(sb1.charAt(i));
                i++;
            }
            if(sb2.isEmpty())
            {
                return sb1.toString();
            }
            sb1=sb2;
            sb2=new StringBuilder();
            set.clear();
        }
    }
    private String solve(String s)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq=0;
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            maxFreq = Math.max(maxFreq,map.get(s.charAt(i)));
        }
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            map2.put(s.charAt(i),map2.getOrDefault(s.charAt(i),0)+1);
            if(map2.get(s.charAt(i)) == maxFreq)
            {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
        
    }
}