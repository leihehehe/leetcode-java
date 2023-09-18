package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class DecodeString {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        StringBuilder currentStr = new StringBuilder();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(currentStr.toString());
                num = 0;
                currentStr = new StringBuilder();
            } else if (c == ']') {
                int times = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for (int j = 0; j < times; j++) {
                    temp.append(currentStr);
                }
                currentStr = temp;
            } else {
                currentStr.append(c);
            }
        }
        return currentStr.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
