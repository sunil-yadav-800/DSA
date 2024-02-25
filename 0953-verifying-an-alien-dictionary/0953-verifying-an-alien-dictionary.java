class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        return solve(words,order);
    }
    private boolean solve(String[] words, String order)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++)
        {
            map.put(order.charAt(i),i);
        }
        
        for(int i=0;i<words.length-1;i++)
        {
            int j=0;
            while(j<words[i].length())
            {
                if(j>=words[i+1].length())
                    return false;
                if(words[i].charAt(j)!=words[i+1].charAt(j))
                {
                    int currCharPostion = map.get(words[i].charAt(j));
                    int nextCharPosition = map.get(words[i+1].charAt(j));
                    if(currCharPostion>nextCharPosition)
                        return false;
                    else
                        break;
                }
                j++;
            }
        }
        return true;
    }
}