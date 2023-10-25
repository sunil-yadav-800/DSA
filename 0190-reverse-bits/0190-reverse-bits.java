public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        /*this approach is not working because bit is appended only till n!=0, but    we need to shift it 32 times*/ 
        /*
        while(n!=0)
        {
            int bit = n & 1;
            ans = ans<<1;
            ans = ans | bit;
            n=n>>>1;
        }
        */
        for(int i=0;i<32;i++)
        {
            int bit = n & 1;
            ans = ans<<1;
            ans = ans | bit;
            n=n>>>1;
        }
        return ans;
    }
}