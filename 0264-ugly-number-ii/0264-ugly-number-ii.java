class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        
        minHeap.offer(1L);
        set.add(1L);
        
        Long ugly = 1L;
        
        for(int i = 0; i < n; i++){
            ugly = minHeap.poll();
            
            for(int factor : new int[]{2,3,5}){
                long nextUgly = factor * ugly;
                if(!set.contains(nextUgly)){
                    minHeap.offer(nextUgly);
                    set.add(nextUgly);
                }
            }
        }
        return ugly.intValue();
    }
}