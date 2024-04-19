package stackAndDeque.monotonic;

import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class StockSpanner {
    ArrayDeque<Pair> stack;
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int count = 1;
        while(!stack.isEmpty()&& stack.peek().price<= price){
            count+=stack.pop().count;
        }
        stack.push(new Pair(count,price));
        return count;
    }
    class Pair{
        int count;
        int price;
        public Pair(int count, int price){
            this.count = count;
            this.price = price;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)
