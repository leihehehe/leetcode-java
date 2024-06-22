package stackAndDeque;

import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class BackspaceCompareSolution {
    public boolean backspaceCompare(String s, String t) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        // Process the first string `s`
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        // Process the second string `t`
        int j = t.length() - 1;
        int count = 0; // To keep track of backspaces in `t`
        while (j >= 0) {
            if (t.charAt(j) == '#') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    if (stack.isEmpty() || stack.pop() != t.charAt(j)) {
                        return false;
                    }
                }
            }
            j--;
        }

        // If there are still elements in the stack, return false
        return stack.isEmpty();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
