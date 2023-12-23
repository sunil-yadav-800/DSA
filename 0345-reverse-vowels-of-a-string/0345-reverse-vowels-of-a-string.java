class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        char[] ch = s.toCharArray();
        int start=0,end=ch.length-1;
        while(start<end)
        {
            if(set.contains(ch[start]) && set.contains(ch[end]))
            {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
            else if(set.contains(ch[start]) && !set.contains(ch[end]))
            {
                end--;
            }
            else if(!set.contains(ch[start]) && set.contains(ch[end]))
            {
                start++;
            }
            else
            {
                start++;
                end--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ch.length;i++)
        {
           sb.append(ch[i]);
        }
        return sb.toString();
    }
}