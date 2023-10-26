class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        int A1 = (ax2-ax1)*(ay2-ay1);
        int A2 = (bx2-bx1)*(by2-by1);
        if(ax2<bx1 || bx2<ax1 || by2<ay1 || ay2<by1)
            return A1+A2;
        int c1 = Math.min(bx2,ax2)-Math.max(bx1,ax1);
        int c2 = Math.min(ay2,by2)-Math.max(by1,ay1);
        return A1+A2-(c1*c2);
    }
}