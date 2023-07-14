package design;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LoggerRateLimiter {
    HashMap<String,Integer> map;
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message,timestamp);
            return true;
        }else{
            int prevTime = map.get(message);
            if(timestamp-prevTime>=10){
                map.put(message,timestamp);
                return true;
            }else{
                return false;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
//leetcode submit region end(Prohibit modification and deletion)
