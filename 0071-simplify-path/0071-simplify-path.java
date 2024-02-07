class Solution {
    public String simplifyPath(String path) {
        return solve(path);
    }
    private String solve(String path)
    {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        String newPath = path+"/";
        
        for(int i=0;i<newPath.length();i++)
        {
            char ch = newPath.charAt(i);
            if(ch == '/')
            {
                if(sb.toString().equals(".."))
                {
                    if(!st.isEmpty())
                    {
                        st.pop();
                    }
                }
                else if(!sb.isEmpty() && !sb.toString().equals("."))
                {
                    st.push(sb.toString());
                }
                sb = new StringBuilder();
            }
            else
            {
                sb.append(ch);
            }
        }
        
        sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.insert(0,"/"+st.pop());
        }
        if(sb.isEmpty())
        {
            sb.append("/");
        }
        return sb.toString();
    }
    
    /*
    '.' --> same directory
    '..' --> go back directory
    '...' or other --> folder name
    */
}