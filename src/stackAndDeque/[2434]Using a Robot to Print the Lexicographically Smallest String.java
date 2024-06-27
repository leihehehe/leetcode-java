package stackAndDeque;

import java.util.ArrayDeque;

class RobotWithStringSolution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] f = new char[n + 1];
        f[n] = (char) ('z' + 1);
        for (int i = n - 1; i >= 0; i--) {
            f[i] = (char) Math.min(f[i + 1], s.charAt(i));
        }

        StringBuilder ans = new StringBuilder();
        ArrayDeque<Character> stk = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stk.push(s.charAt(i));
            while (!stk.isEmpty() && stk.peek() <= f[i + 1]) {
                ans.append(stk.pop());
            }
        }
        return ans.toString();
    }
}

