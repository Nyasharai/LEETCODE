class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int pair[] : adjacentPairs){
            graph.computeIfAbsent(pair[0], k-> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], k-> new ArrayList<>()).add(pair[0]);
        }
        
        int start = -1;
        for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet()){
            if(entry.getValue().size() == 1){
                start = entry.getKey();
                break;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        set.add(start);
        queue.add(start);
        
        while(!queue.isEmpty()){
            int val = queue.poll();
            res.add(val);
            for(int n : graph.get(val)){
                if(!set.contains(n)){
                    queue.add(n);
                    set.add(n);
                }
            }
        }
        
        return res.stream().mapToInt(i -> i).toArray();
    }
}