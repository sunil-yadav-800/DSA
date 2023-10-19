class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int element = nums[i];
            int chair = element-1;

            if(element>=1 && element<=n){
                if(nums[chair]!=element){
                    int temp = nums[i];
                    nums[i]=nums[chair];
                    nums[chair]=temp;
                    i--;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
}