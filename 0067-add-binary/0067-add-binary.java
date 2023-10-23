class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i=a.length()-1,j=b.length()-1;
        char carry = '0';
        while(i>=0 && j>=0)
        {
            char ch1 = a.charAt(i);
            char ch2 = b.charAt(j);
            if(ch1 == '1' && ch2 == '1')
            {
                if(carry == '1')
                {
                    carry = '1';
                    sb.append('1');
                }
                else
                {
                    carry = '1';
                    sb.append('0');
                }
            }
            else if((ch1 == '1' && ch2 == '0') || (ch1 == '0' && ch2 == '1'))
            {
                if(carry == '1')
                {
                    carry = '1';
                    sb.append('0');
                }
                else
                {
                    carry = '0';
                    sb.append('1');
                }
            }
            else
            {
                if(carry == '1')
                {
                    carry = '0';
                    sb.append('1');
                }
                else
                {
                    carry = '0';
                    sb.append('0');
                }
            }
            i--;
            j--;
        }
        while(i>=0)
        {
           char ch = a.charAt(i);
            if(ch == '1' && carry == '1')
            {
                carry = '1';
                sb.append('0');
            }
            else if((ch == '0' && carry == '1') || (ch == '1' && carry == '0'))
            {
                carry = '0';
                sb.append('1');
            }
            else
            {
                carry = '0';
                sb.append('0');
            }
                
            i--;
        }
        while(j>=0)
        {
           char ch = b.charAt(j);
            if(ch == '1' && carry == '1')
            {
                carry = '1';
                sb.append('0');
            }
            else if((ch == '0' && carry == '1') || (ch == '1' && carry == '0'))
            {
                carry = '0';
                sb.append('1');
            }
            else
            {
                carry = '0';
                sb.append('0');
            }
                
            j--;
        }
        if(carry == '1')
        {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}