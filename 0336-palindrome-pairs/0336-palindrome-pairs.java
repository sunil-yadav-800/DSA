class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            String str = words[i];
            map.put(new StringBuilder(str).reverse().toString(),i);
        }
        
        //case1 
        int index = map.getOrDefault("",-1);
        if(index != -1)
        {
            for(int i=0;i<words.length;i++)
            {
                if(index!=i && isPalindrome(words[i]))
                {
                    List<Integer> li = new ArrayList<>();
                    li.add(index);
                    li.add(i);
                    ans.add(li);
                    li=new ArrayList<>();
                    li.add(i);
                    li.add(index);
                    ans.add(li);
                }
            }
        }
        //case 2
        for(int i=0;i<words.length;i++)
        {
            if(map.containsKey(words[i]) && map.get(words[i])!=i)
            {
                List<Integer> li = new ArrayList<>();
                li.add(map.get(words[i]));
                li.add(i);
                ans.add(li);
            }
        }
        //case 3
        for(int i=0;i<words.length;i++)
        {
            String str = words[i];
            for(int j=1;j<str.length();j++)
            {
                String left = str.substring(0,j);
                String right = str.substring(j);
                if(map.containsKey(right) && isPalindrome(left))
                {
                    List<Integer> li = new ArrayList<>();
                    li.add(map.get(right));
                    li.add(i);
                    ans.add(li);
                }
                if(map.containsKey(left) && isPalindrome(right))
                {
                    List<Integer> li = new ArrayList<>();
                    li.add(i);
                    li.add(map.get(left));
                    ans.add(li);
                }
            }
        }
        return ans;
    }
    public boolean isPalindrome(String str)
    {
        int i=0,j=str.length()-1;
        while(i<j)
        {
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}