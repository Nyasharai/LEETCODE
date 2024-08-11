class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            
            while(!stack.isEmpty() && stack.peekLast() > n && stack.size() + (nums.length - i) > k){
                stack.pollLast();
            }
            
            if(stack.size() < k){
                stack.offerLast(n);
            }
        }
        
        int r[] = new int[k];
        int index = 0;
        for(int n : stack){
            r[index++] = n;
        }
        
        return r;
    }
}