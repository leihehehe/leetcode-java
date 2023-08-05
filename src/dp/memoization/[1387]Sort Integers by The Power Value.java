package dp.memoization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class SortIntegersByThePowerValue {
    Map<Integer,Integer> map = new HashMap<>();
    public int getKth(int lo, int hi, int k) {
        int[][] res = new int[hi-lo+1][2];
        for(int i = lo,j = 0;i<=hi;i++,j++){
            res[j][0] = i;
            res[j][1] = getPower(i);
        }
        Arrays.sort(res,(a, b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        return res[k-1][0];
    }

    public int getPower(int x){

        if(x==1){
            return 0;
        }
        if(map.containsKey(x)){
            return map.get(x);
        }
        int power = 0;
        //even
        if(x%2==0){
            power = 1+ getPower(x/2);
        }else{
            power = 1 + getPower(3*x+1);
        }
        map.put(x,power);
        return power;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
