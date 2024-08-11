class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>( 
            (a,b) -> map.get(b) - map.get(a)
        );
        maxHeap.addAll(map.keySet());
        
        StringBuilder r = new StringBuilder();
        Character prevChar = null;
        int prevFreq = 0;
        
        while(!maxHeap.isEmpty()){
            Character charToAdd =  maxHeap.poll();
            r.append(charToAdd);
            map.put(charToAdd, map.get(charToAdd) - 1);
            
            if(prevChar != null && prevFreq > 0){
                maxHeap.offer(prevChar);
            }
            
            prevChar = charToAdd;
            prevFreq = map.get(charToAdd);
        }
        
        return r.length() == s.length() ? r.toString() : "";
    }
}