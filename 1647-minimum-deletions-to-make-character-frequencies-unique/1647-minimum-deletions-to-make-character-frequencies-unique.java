class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c : s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int freq : freqMap.values()){
            countMap.put(freq, countMap.getOrDefault(freq, 0) + 1);
        }
        
        int del = 0;
        Set<Integer> seen = new HashSet<>();
        for(int freq : countMap.keySet()){
            int count = countMap.get(freq);
            
            while(count > 0){
                int newFreq = freq;
                while(newFreq > 0 && seen.contains(newFreq)){
                    newFreq--;
                }
                if(newFreq > 0){
                    del += freq - newFreq;
                    seen.add(newFreq);
                }
                else{
                    del += freq;
                }
                count--;
            }
            seen.add(freq);
        }
        return del;
    }
}