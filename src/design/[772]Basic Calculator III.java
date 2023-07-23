package design;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class BasicCalculatorIII {
    public int calculate(String s) {
        s = s.replace(" ", "");
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            queue.addLast(s.charAt(i));
        }
        return getResult(queue);
    }

    public int getResult(Deque<Character> queue) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        while (!queue.isEmpty()) {
            char c = queue.pop();
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (c == '(') {
                num = getResult(queue);
            }
            if (!Character.isDigit(c) || queue.isEmpty()) {
                switch (sign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop()/num);
                }
                sign = c;
                num = 0;
            }

            if(c==')'){
                break;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
