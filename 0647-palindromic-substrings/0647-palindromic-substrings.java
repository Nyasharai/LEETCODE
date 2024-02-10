class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        // Check for odd length palindromes
        for (int center = 0; center < n; center++) {
            int left = center;
            int right = center;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        // Check for even length palindromes
        for (int centerLeft = 0; centerLeft < n - 1; centerLeft++) {
            int left = centerLeft;
            int right = centerLeft + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}
