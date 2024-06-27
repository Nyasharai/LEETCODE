class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int count = 0;
        HashMap<Character,Integer> map =  new HashMap<>();
        while(end < n){
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end),0)+1);
            while(map.getOrDefault('a', 0) >= 1 && map.getOrDefault('b', 0) >= 1 && map.getOrDefault('c', 0) >= 1)
            {
                count = count + n - end;
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                start++;
            }
            end++;
        }
        return count;
    }
}