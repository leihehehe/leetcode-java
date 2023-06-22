package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i =0;i<tokens.length;i++){
            String token = tokens[i];
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int second = stack.pop();
                int first = stack.pop();
                int res = 0;
                if(token.equals("+"))
                    res=first+second;
                if(token.equals("-"))
                    res=first-second;
                if(token.equals("*"))
                    res=first * second;
                if(token.equals("/"))
                    res=first/second;
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public int evalRPN2(String[] tokens) {
        //["2","1","+","3","*"]
        //[4,13/5]
        Deque<String> stack = new ArrayDeque<>();
        for(String str:tokens){
            //if the string is a number
            if(isNumber(str)){
                stack.push(str);
            }else{
                int first = Integer.parseInt(stack.pop());
                int second =Integer.parseInt(stack.pop());
                switch(str){
                    case "+":
                        stack.push(String.valueOf(first+second));
                        break;
                    case "-":
                        stack.push(String.valueOf(second-first));
                        break;
                    case "*":
                        stack.push(String.valueOf(second*first));
                        break;
                    case "/":
                        stack.push(String.valueOf(second/first));
                        break;
                    default:
                }
            }
        }
        return Integer.parseInt(stack.peek());
    }
    public boolean isNumber(String str){
        return !str.equals("+") && !str.equals("-") && !str.equals("*")&& !str.equals("/");
    }
}
