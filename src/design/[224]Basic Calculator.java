package design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 一个stack
 */
class BasicCalculatorSolution1 {
    public int calculate(String s) {
        return getResult(s, 0)[0];
    }

    public int[] getResult(String s, int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        for(int i =start;i<s.length();i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (c == '(') {
                int[] answer = getResult(s,i+1);
                num = answer[0];
                i = answer[1];
            }

            if (!Character.isDigit(c) && c != ' ' || i==s.length()-1) {
                switch (sign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(Math.floorDiv(stack.pop(), num));
                }
                sign = c;
                num = 0;
            }
            //右括号检测要放在后面，因为我们每次循环的计算的都是前面的结果
            if (c == ')') {
                int res = 0;
                while (!stack.isEmpty()) {
                    res += stack.pop();
                }
                return new int[]{res,i};
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return new int[]{res,s.length()-1};
    }
}
class BasicCalculatorSolution2 {
    public int calculate(String s) {
        Deque<Character> queue = new LinkedList<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            queue.addLast(c);
        }
        return getResult(queue);
    }
    public int getResult(Deque<Character> queue){
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        while(!queue.isEmpty()){
            char c = queue.pollFirst();
            if(c=='('){
                num = getResult(queue);
            }
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }

            if((!Character.isDigit(c) &&c!=' ') ||queue.isEmpty()){
                switch (sign){
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                }
                sign = c;
                num = 0;
            }

            if(c==')'){
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
