class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        //if we do & of two number, result will always be smaller or equal to smallest no.
        while(left<right)
        {
            right=right&(right-1);
        }
        return right;
    }
}