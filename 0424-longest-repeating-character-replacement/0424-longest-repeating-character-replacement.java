class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0){
            return 0;
        }
        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        int maxFreq = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(ch));
            
            if((right - left + 1) - maxFreq > k){
                char ch1 = s.charAt(left);
                freqMap.put(ch1, freqMap.get(ch1) - 1);
                left++;
            }
            
            maxLength = Math.max(right-left+1, maxLength);
        }
        
        return maxLength;
    }
}