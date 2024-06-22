package stackAndDeque;

import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class CalPointsSolution {
    public int calPoints(String[] operations) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(String operation:operations){
            switch (operation) {
                case "+":
                    int first = stack.poll();
                    int second = stack.peek();
                    int sum = first + second;
                    stack.push(first);
                    stack.push(sum);
                    break;
                case "D":
                    stack.push(stack.peek()*2);
                    break;
                case "C":
                    stack.poll();
                    break;
                default:
                    stack.push(Integer.parseInt(operation));
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
