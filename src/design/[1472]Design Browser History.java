package design;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class BrowserHistoryMethod1 {
    private String url;
    private Deque<String> backHistory;
    private Deque<String> forwardHistroy;
    /**
     * the most suitable ds for this linkedlist.
     * the head of the queue will be the least recently visted url
     * the tail of the queue will be the most recently visited url
     * 1-2-3-4
     */
    public BrowserHistoryMethod1(String homepage) {
        url = homepage;
        backHistory = new ArrayDeque<>();
        forwardHistroy = new ArrayDeque<>();
    }

    public void visit(String url) {
        backHistory.push(this.url);
        this.url = url;
        forwardHistroy.clear();
    }

    public String back(int steps) {
        if(backHistory.isEmpty()){
            return url;
        }
        for(int i =1;i<=steps;i++){
            if(backHistory.isEmpty()){
                break;
            }
            forwardHistroy.push(this.url);
            this.url = backHistory.pop();
        }
        return url;
    }

    public String forward(int steps) {
        if(forwardHistroy.isEmpty()){
            return url;
        }
        for(int i =1;i<=steps;i++){
            if(forwardHistroy.isEmpty()){
                break;
            }
            backHistory.push(this.url);
            this.url = forwardHistroy.pop();
        }
        return url;
    }
}
class BrowserHistoryMethod2 {
    private String url;
    private String[] history;
    private int cur;
    private int tail;
    /**
     * the most suitable ds for this linkedlist.
     * the head of the queue will be the least recently visted url
     * the tail of the queue will be the most recently visited url
     * [1,2,3,4]
     */
    public BrowserHistoryMethod2(String homepage) {
        url = homepage;
        history = new String[5000];
        cur = 0;
        tail = 0;
        //[head,tail]
        history[cur] = homepage;
    }

    public void visit(String url) {
        history[++cur] = url;
        tail = cur;
    }

    public String back(int steps) {
        for(int i =1;i<=steps;i++){
            if(cur-1<0){
                break;
            }
            cur--;
        }
        return history[cur];
    }

    public String forward(int steps) {
        for(int i =1;i<=steps;i++){
            if(cur+1>tail){
                break;
            }
            cur++;
        }
        return history[cur];
    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
//leetcode submit region end(Prohibit modification and deletion)
