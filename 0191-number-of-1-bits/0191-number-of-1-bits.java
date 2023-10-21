public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Approach1(n);
    }
    public int Approach1(int n)
    {
        int count=0;
        while(n!=0)
        {
            if((n&1)==1)
                count++;
            n=n>>>1;  //for unsigned integer >>> //for signrdin >>
        }
        return count;
    }
}