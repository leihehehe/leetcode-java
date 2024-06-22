package stackAndDeque;

import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class BrowserHistory {
    ArrayDeque<String> backward = new ArrayDeque<>();
    ArrayDeque<String> forward = new ArrayDeque<>();
    public BrowserHistory(String homepage) {
        backward.push(homepage);
    }

    public void visit(String url) {
        backward.push(url);
        forward.clear();;
    }

    public String back(int steps) {
        while(steps-->0){
            if(backward.size()<=1){
                break;
            }else{
                forward.push(backward.pop());
            }
        }
        return backward.peek();
    }

    public String forward(int steps) {
        while(steps-->0){
            if(forward.size()<=0){
                break;
            }else{
                backward.push(forward.pop());
            }
        }
        return backward.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
//leetcode submit region end(Prohibit modification and deletion)
