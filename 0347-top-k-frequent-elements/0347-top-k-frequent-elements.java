class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.getValue(), b.getValue())
        );
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        int topEle[] = new int[k];
        for(int i = k - 1; i >= 0; i--){
            topEle[i] = minHeap.poll().getKey();
        }
        
        return topEle;
    }
}