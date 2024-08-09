class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        
        if(s.isEmpty()){
            return false;
        }
        
        boolean hasNum = false;
        boolean hasDot = false;
        boolean hasE = false;
        boolean hasSign = false;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c >= '0' && c <= '9'){
                hasNum = true;
            }
            else if(c == '.'){
                if(hasE || hasDot) return false;
                hasDot = true;
            }
            else if(c == 'e' || c == 'E'){
                if(hasE || !hasNum || i == 0 || i == s.length() - 1) return false;
                hasE = true;
                hasNum = false;
            }
            else if(c =='+' || c == '-'){
                if(i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')return false;
            }
            else{
                return false;
            }
        }
        return hasNum;
    }
}