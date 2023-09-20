package strings;

//leetcode submit region begin(Prohibit modification and deletion)
class StringToInteger {
    public int myAtoi(String s) {
        int i = 0;
        // remove white spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // if the string is empty or we've reached the end
        if (i == s.length()) return 0;

        boolean positive = true;

        // handle sign
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            if (s.charAt(i) == '-') {
                positive = false;
            }
            i++;
        }

        long res = 0;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            res = res * 10 + s.charAt(i) - '0';
            i++;

            // check for positive overflow
            if (positive && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            // check for negative overflow
            if (!positive && -res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return positive ? (int) res : -(int) res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
