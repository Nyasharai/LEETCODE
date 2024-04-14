class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int freq[] = new int[26];
        boolean seen[] = new boolean[26];
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            
            if(seen[ch - 'a'])continue;
            
            while(st.size() > 0 && st.peek() > ch && freq[st.peek() - 'a']>0){
                char rev = st.pop();
                seen[rev - 'a'] = false;
            }
            st.push(ch);
            seen[ch - 'a'] = true;
        }
        char ans[] = new char[st.size()];
        int i = ans.length-1;
        while(i >= 0){
            ans[i--] = st.pop();
        }
        return new String(ans);
    }
}