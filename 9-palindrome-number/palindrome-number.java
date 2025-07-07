class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending in 0 (but not 0 itself) can't be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }

        // When length is even: x == reversed
        // When length is odd: x == reversed/10 (middle digit doesn't matter)
        return x == reversed || x == reversed / 10;
    }
}
