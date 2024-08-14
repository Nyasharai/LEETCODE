class Solution {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for(char digit : num.toCharArray()){
            while(k > 0 && !stack.isEmpty() && stack.peek() > digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        
        res.reverse();
        String finalS = res.toString().replaceAll("^0+", "");
        return finalS.isEmpty() ? "0" : finalS;
    }
}