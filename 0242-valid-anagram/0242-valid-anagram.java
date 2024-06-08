class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char st[] = s.toCharArray();
        char at[] = t.toCharArray();
        Arrays.sort(st);
        Arrays.sort(at);
        return Arrays.equals(st,at);
        
    }
}