class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res,"",0,0,n);
        return res;
    }
    public static void generate(List<String> res, String current, int open, int close, int max){
        if(current.length() == 2 * max){
            res.add(current);
            return;
        }
        
        if(open < max){
            generate(res, current + "(", open + 1, close, max);
        }
        
        if(close < open){
            generate(res, current + ")", open, close + 1, max);
        }
    }
}