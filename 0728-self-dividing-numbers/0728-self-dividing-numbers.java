class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for(int num=left;num<=right;num++)
        {
            if(selfDeviding(num))
            {
                ans.add(num);
            }
        }
        return ans;
    }
    public boolean selfDeviding(int num)
    {
        int n=num;
        while(n>0)
        {
            int d = n%10;
            if(d==0 || num%d!=0)
            {
                return false;
            }
            n=n/10;
        }
        return true;
    }
}