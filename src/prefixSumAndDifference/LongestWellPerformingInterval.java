package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 1124
 */
public class LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        //hour>8     => a tiring day -> 1
        //hour <= 8     =>a non-tiring day -> -1
        //well-performing interval => the number of tiring days larger than the number of non-tiring day.  -> sum of a interval should be larger than 0
        for(int i=0;i<hours.length;i++){
            if(hours[i]>8) hours[i]=1;
            else hours[i]=-1;
        }
        int[] preSum= new int[hours.length+1];
        preSum[0] = 0;
        int res=0;
        Map<Integer,Integer> valToIndex = new HashMap<>();
        for(int i =1;i<preSum.length;i++){
            preSum[i] = preSum[i-1]+hours[i-1];
            //only put value when there is no specific key
            if(!valToIndex.containsKey(preSum[i])){
                valToIndex.put(preSum[i],i);
            }
            //hours[0..i-1] is a well-performing interval
            if(preSum[i]>0) res = Math.max(res, i);
            else{
                // not a well-performing interval
                if(valToIndex.containsKey(preSum[i]-1)){
                    int j = valToIndex.get(preSum[i]-1);
                    res = Math.max(res,i-j);
                }
            }
        }
        return res;
    }
}
