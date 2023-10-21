public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //return Approach1(n);  
        return Approach2(n);
    }
    public int Approach1(int n)
    {
        // T- O(32);
        int count=0;
        while(n!=0)
        {
            if((n&1)==1)
                count++;
            n=n>>>1;  //for unsigned integer >>> //for signrdin >>
        }
        return count;
    }
    public int Approach2(int n)
    {
        // T- O(number of set bits)
        int cnt=0;
        while(n!=0) 
        {
            cnt++;
            n=n&(n-1);
        }
        return cnt;
    }
}