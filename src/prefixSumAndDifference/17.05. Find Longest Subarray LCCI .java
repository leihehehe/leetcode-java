package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

class FindLongestSubarraySolution {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        int sum = 0;
        //preSum -> index
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int leftIndex = n+1;
        int rightIndex = n+1;
        for(int i = 0;i<n;i++){
            char c = array[i].charAt(0);
            if(Character.isDigit(c)){
                sum+=1;
            }else{
                sum+=-1;
            }
            if(map.containsKey(sum)){
                //只有长度更长的时候才更新
                if(i - map.get(sum) > rightIndex - leftIndex){
                    leftIndex = map.get(sum);
                    rightIndex = i;
                }
            }else{
                //因为遍历的时候，i肯定是比之前的index大，所以只有在map中没有sum的时候才更新这个sum对应的index
                map.put(sum, i);
            }
        }

        if(leftIndex==n+1) return new String[0];
        int len = rightIndex-leftIndex;
        String[] res = new String[len];
        int pos = 0;
        for(int i = leftIndex+1;i<=rightIndex;i++){
            res[pos++] = array[i];
        }
        return res;
    }
}