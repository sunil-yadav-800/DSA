class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            char ch = t.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        String ans="";
        int matched=0; //how many character matched till now
        int dmct=t.length(); //desired matched count
        HashMap<Character,Integer> map1 = new HashMap<>();
        int i=0,j=0;
        while(j<s.length())
        {
                char chh = s.charAt(j); //being added character
                map1.put(chh,map1.getOrDefault(chh,0)+1);
                if(map1.getOrDefault(chh,0)<=map2.getOrDefault(chh,0))
                {
                    matched++;
                }
                j++;
            
            while(i<j && matched==dmct)
            {
                if(ans.length()==0 || ans.length()>(j-i))
                {
                    ans = s.substring(i,j);
                }
                char ch = s.charAt(i); //being removed char
                map1.put(ch,map1.get(ch)-1);
                if(map1.getOrDefault(ch,0)<map2.getOrDefault(ch,0))
                {
                    matched--;
                }
                i++;
            }
        }
        
        
        return ans;
    }
}