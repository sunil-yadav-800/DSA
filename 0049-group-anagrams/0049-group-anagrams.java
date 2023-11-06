class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> hm = new HashMap<>();
        
        for(int i=0;i<strs.length;i++)
        {
            char[] arr = new char[26];
            char[] s = strs[i].toCharArray();
            for(int j=0;j<s.length;j++)
            {
                arr[s[j]-'a']++;
            }
            String newStr = new String(arr);
            System.out.println(arr.toString() + " "+newStr);
            if(!hm.containsKey(newStr))
            {
                hm.put(newStr,new ArrayList<>());
            }
            hm.get(newStr).add(strs[i]);
        }
        res.addAll(hm.values());
        return res;
    }
}