class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> groupAnagrams = new HashMap<>();
        for(String str : strs)
        {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            if(!groupAnagrams.containsKey(sortedStr))
            {
                groupAnagrams.put(sortedStr, new ArrayList<>());
            }
            
            groupAnagrams.get(sortedStr).add(str);
        }
        return new ArrayList<>(groupAnagrams.values());
    }
}