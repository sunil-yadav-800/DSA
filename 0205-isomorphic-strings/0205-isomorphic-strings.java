class Solution {
    public boolean isIsomorphic(String s, String t) {
        String first = IsEqual(s);
        String second = IsEqual(t);
        return first.equals(second);
        
    }
    public String IsEqual(String str)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<str.length();i++)
        {
            if(!map.containsKey(str.charAt(i)))
            {
                map.put(str.charAt(i),i);
            }
            builder.append(Integer.toString(map.get(str.charAt(i))));
            builder.append(" ");
        }
        return builder.toString();
    }
}