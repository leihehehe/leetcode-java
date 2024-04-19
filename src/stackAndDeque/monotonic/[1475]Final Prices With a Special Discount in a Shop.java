package stackAndDeque.monotonic;

import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class FinalPrices {
    public int[] finalPrices(int[] prices) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = prices.length;
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && prices[stack.peek()]>=prices[i]){
                prices[stack.pop()]-= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
