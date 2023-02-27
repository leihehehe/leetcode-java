package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 359
 */
public class LoggerRateLimiter {
    Map<String,Integer> map;
    public LoggerRateLimiter() {
        map =new HashMap<>();
    }

    /**
     * O(N)
     * O(M) -> M = the number of messages
     * @param timestamp
     * @param message
     * @return
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            System.out.print(map.get(message));
            if(map.get(message)+10>timestamp) return false;
        }

        map.put(message,timestamp);
        return true;
    }
}
