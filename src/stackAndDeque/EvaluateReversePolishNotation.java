package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
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
