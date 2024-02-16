class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
            PriorityQueue<int[]> pq = new PriorityQueue <> ((a,b)->Integer.compare(a[1], b[1]));
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                pq.add(new int[] {entry.getKey(), entry.getValue()});
            }
            
            while(k-- > 0){
                int[] currmin = pq.poll();
                if(currmin[1] > 1){
                    currmin[1]--;
                    pq.add(currmin);
                }
            }
            return pq.size();
        }
    }
