class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int carry = 0;
        int index=num.length-1;
        while(index>=0 && k>0)
        {
            int dSum = num[index]+k%10+carry;
            carry = dSum/10;
            ans.add(0,dSum%10);
            index--;
            k=k/10;
        }
        while(index>=0)
        {
            int dSum = num[index]+carry;
            carry = dSum/10;
            ans.add(0,dSum%10);
            index--;
        }
        while(k>0)
        {
            int dSum = k%10+carry;
            carry = dSum/10;
            ans.add(0,dSum%10);
            k=k/10;
        }
        if(carry>0)
        {
            ans.add(0,carry);
        }
        return ans;
        //return Collections.reverse(ans);
    }
}