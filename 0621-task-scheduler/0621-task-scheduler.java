class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCount = new HashMap<>();
        for(char task : tasks){
            taskCount.put(task, taskCount.getOrDefault(task,0) + 1);
        }
        
        int maxFreq = 0;
        int maxFreqCount = 0;
        for(int freq : taskCount.values()){
            if(freq > maxFreq){
                maxFreq = freq;
                maxFreqCount = 1;
            }
            else if(freq == maxFreq){
                maxFreqCount++;
            }
        }
        
        int minInterval = (maxFreq - 1) * (n + 1) + maxFreqCount;
        return Math.max(minInterval, tasks.length);
    }
}