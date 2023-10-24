class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        if(numRows == 2)
        {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            
            for(int i=0;i<s.length();i++)
            {
                if(i%2==0)
                {
                    sb1.append(s.charAt(i));
                }
                else
                {
                    sb2.append(s.charAt(i));
                }
            }
            return sb1.append(sb2).toString();
        }
        
        List<List<Character>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            ans.add(new ArrayList<>());
        }
        int f=0,b=numRows-2;
        for(int i=0;i<s.length();i++)
        {
            if(f<numRows)
            {
                ans.get(f).add(s.charAt(i));
                f++;
                if(f == numRows)
                {
                    b=numRows-2;
                }
            }
            else if(b>=1)
            {
                ans.get(b).add(s.charAt(i));
                b--;
                if(b == 0)
                {
                    f=0;
                }
            }
            
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ans.size();i++)
        {
            for(int j=0;j<ans.get(i).size();j++)
            {
                sb.append(ans.get(i).get(j));
            }
        }
        return sb.toString();
    }
}