class Solution {
    public boolean canCross(int[] stones) {
        Set<Integer> stonePos = new HashSet<>();
        for(int stone : stones){
            stonePos.add(stone); // 2 3 1 1 4
        }
        
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        dp.put(stones[0], new HashSet<>(Arrays.asList(0)));
        
        for(int stone : stones){
            if(!dp.containsKey(stone)) continue;
            Set<Integer> jumps = dp.get(stone);
            for(int jump : jumps){
                for(int nextJump = jump - 1; nextJump <= jump + 1; nextJump++){
                    if(nextJump > 0){
                        int nextStone = stone + nextJump;
                        if(stonePos.contains(nextStone)){
                            dp.computeIfAbsent(nextStone, k -> new HashSet<>()).add(nextJump);
                        }
                    }
                }
            }
        }
        return dp.containsKey(stones[stones.length - 1]);
    }
}

