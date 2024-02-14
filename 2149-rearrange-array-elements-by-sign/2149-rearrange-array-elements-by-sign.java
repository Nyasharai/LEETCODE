class Solution {
    public int[] rearrangeArray(int[] nums) {
        int l = nums.length, p = 0, n = 1;
        int result[] = new int [l];
        for(int ele : nums){
            if(ele > 0){
                result[p] = ele;
                p+=2;
            }
            else{
                result[n] = ele;
                n+=2;
            }
        }
        
        return result;
    }
}