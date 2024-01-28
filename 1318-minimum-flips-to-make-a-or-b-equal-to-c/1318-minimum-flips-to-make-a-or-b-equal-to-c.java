class Solution {
    public int minFlips(int a, int b, int c) {
        int count=0;
        while(c>0 || (a|b)>0)
        {
            int abit = a&1;
            int bbit = b&1;
            int cbit = c&1;
            if(cbit == 1)
            {
                //than atleast one bit is required as 1 to get 1
                if(abit == 0 && bbit == 0)
                {
                    count++;
                }
            }
            else
            {
                if(abit == 1)
                    count++;
                
                if(bbit == 1)
                    count++;
            }
            
            a=a>>1;
            b=b>>1;
            c=c>>1;
        }
        return count;
    }
}