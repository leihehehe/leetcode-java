package prefixSumAndDifference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class CountTripletsSolution {
    public int countTriplets(int[] arr) {
        int xorRes = 0;
        int n = arr.length;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(0,new ArrayList<>());
        map.get(0).add(-1);
        int res = 0;
        for(int i = 0;i<n;i++){
            xorRes^= arr[i];
            if(map.containsKey(xorRes)){
                for(int index:map.get(xorRes)){
                    if(index<i-1)
                        res+=i-index-1;
                }
            }
            if(!map.containsKey(xorRes)){
                map.put(xorRes, new ArrayList<>());
            }
            map.get(xorRes).add(i);
        }
        return res;
    }
}