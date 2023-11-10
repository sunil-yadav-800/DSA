class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0)
        {
            return ans;
        }
        Solve(digits,0,"",ans);
        return ans;
    }
    private void Solve(String str, int idx, String curr, List<String> ans)
    {
        //base case
        if(idx == str.length())
        {
            ans.add(curr);
            return;
        }
        String mappedValue = getValue(str.charAt(idx));
        for(int i=0;i<mappedValue.length();i++)
        {
            Solve(str,idx+1,curr+mappedValue.charAt(i),ans);
        }
    }
    private String getValue(char ch)
    {
        switch(ch)
        {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}