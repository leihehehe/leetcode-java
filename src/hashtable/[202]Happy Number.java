package hashtable;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class HappyNumber {
    public boolean isHappy(int n) {
        return calculate(n);
    }
    public boolean calculate(int n){
        int sum = 0;
        Set<Integer> check = new HashSet<>();
        while(n!=0){
            int cur = n%10;
            sum+=Math.pow(cur,2);
            n = n/10;
            if(n==0){
                if(sum==1)
                    return true;
                if(check.contains(sum))
                    return false;
                check.add(sum);
                n = sum;
                sum=0;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
