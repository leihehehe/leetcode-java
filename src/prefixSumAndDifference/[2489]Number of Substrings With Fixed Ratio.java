package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

class FixedRatioSolution {
    public long fixedRatio(String s, int num1, int num2) {
        //num1:num2
        //a -> the number of 0s, b -> the number of 1s
        //(countZero[j] - countZero[i])/ (countOne[j] - countOne[i]) = num1/num2
        //countZero[j] - countZero[i] = (num1/num2) * (countOne[j] - countOne[i])
        //countZero[j] - countZero[i] = (num1/num2)* countOne[j] - (num1/num2)*countOne[i]
        //countZero[j] - (num1/num2)*countOne[j] = countZero[i] - (num1/num2)*countOne[i]
        // (countZero[j]*num2 - num1*countOne[j])/num2 = countZero[i]*num2 - num1*countOne[i]
        long countZero = 0, countOne = 0;
        long res = 0;
        Map<Long,Long> map= new HashMap<>();
        map.put(0L,1L);
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='1') countOne++;
            else countZero++;
            long target = countZero * num2 - num1 * countOne;
            res+= map.getOrDefault(target, 0L);
            map.put(target,map.getOrDefault(target, 0L)+1L);
        }
        return res;
    }
}
