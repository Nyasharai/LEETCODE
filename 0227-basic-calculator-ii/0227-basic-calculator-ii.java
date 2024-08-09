class Solution {
    public int calculate(String s) {
       int currRes = 0;   // Current result after considering the operator
        int res = 0;       // Final result
        int num = 0;       // Current number being processed
        char op = '+';     // Last operator seen (initially '+')
        
        // Append a '+' at the end to process the final number
        s += "+";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // If the character is a digit, build the number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            
            // If the character is an operator, process the current number
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // Apply the previous operator
                switch (op) {
                    case '+':
                        currRes += num;
                        break;
                    case '-':
                        currRes -= num;
                        break;
                    case '*':
                        currRes *= num;
                        break;
                    case '/':
                        // Python's int() truncates towards zero
                        currRes = (currRes >= 0) ? currRes / num : -(-currRes / num);
                        break;
                }
                
                // If the operator is '+' or '-', add the current result to the final result
                if (ch == '+' || ch == '-') {
                    res += currRes;
                    currRes = 0;
                }
                
                // Update the operator and reset the current number
                op = ch;
                num = 0;
            }
        }

        return res;
    }
}