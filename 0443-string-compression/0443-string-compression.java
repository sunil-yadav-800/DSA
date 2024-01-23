class Solution {
    public int compress(char[] chars) {
        int ans=-1;
        char ch = chars[0];
        int cnt=1;
        for(int i=1;i<chars.length;i++)
        {
            if(chars[i] == ch)
            {
                cnt++;
            }
            else
            {
                chars[++ans]=ch;
                if(cnt>1)
                {
                    String str = String.valueOf(cnt);
                    for(int k=0;k<str.length();k++)
                    {
                        chars[++ans]=str.charAt(k);
                    }
                }
                cnt=1;
                ch=chars[i];
            }
        }
        //for last groups
        chars[++ans]=ch;
        if(cnt>1)
        {
            String str = String.valueOf(cnt);
            for(int k=0;k<str.length();k++)
            {
                chars[++ans]=str.charAt(k);
            }
        }
        return ans+1;
    }
}