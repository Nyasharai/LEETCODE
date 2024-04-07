class Solution {
    public boolean checkValidString(String s) {

        ArrayDeque<Integer> openBrackets = new ArrayDeque<> ();
        ArrayDeque<Integer> asterisks = new ArrayDeque<> ();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openBrackets.push(i);
            }
            else if (ch == '*') {
                asterisks.push(i);
            } 
            else {
                if (!openBrackets.isEmpty()) {
                    openBrackets.pop();
                } else if (!asterisks.isEmpty()) {
                    asterisks.pop();
                } else {
                    return false;
                }
            }
        }

        // Check if there are remaining open brackets and asterisks that can balance them
        while (!openBrackets.isEmpty() && !asterisks.isEmpty()) {
            // If an open bracket appears after an asterisk, it cannot be balanced, return false
            if (openBrackets.pop() > asterisks.pop()) {
                return false; // '*' before '(' which cannot be balanced.
            }
        }

        return openBrackets.isEmpty();
    }
}