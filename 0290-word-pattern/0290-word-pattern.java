class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] wordString = s.split(" ");
        if(pattern.length() != wordString.length)
            return false;
        HashMap<Character,String> map = new HashMap<Character,String>();
        for(int i=0;i<pattern.length();i++)
        {
            if(map.containsKey(pattern.charAt(i)))
            {
                String mappedWord = map.get(pattern.charAt(i));
                String currentWordString = wordString[i];
                if(!mappedWord.equals(currentWordString))
                    return false;
            }
            else
            {
                if(map.containsValue(wordString[i]))
                    return false;
                map.put(pattern.charAt(i),wordString[i]);
            }
        }
        return true;
    }
}