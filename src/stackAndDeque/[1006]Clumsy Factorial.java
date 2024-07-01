package stackAndDeque;

import java.util.ArrayDeque;

class ClumsySolution {
    public int clumsy(int n) {
        if(n==1) return n;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(n);
        for(int i = n-1,j=0;i>0;i--,j++){

            switch (j%4) {
                case 0:
                    stack.push(i*stack.pop());
                    break;
                case 1:
                    stack.push(stack.pop()/i);
                    break;
                case 2:
                    stack.push(i);
                    break;
                case 3:
                    stack.push(-i);
                    break;
                default:
                    break;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }

}
