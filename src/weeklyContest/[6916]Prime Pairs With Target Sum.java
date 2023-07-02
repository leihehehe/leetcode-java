package weeklyContest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PrimePairsWithTargetSum {
    public List<List<Integer>> findPrimePairs(int n) {
        //initialize primes
        boolean[] primes = new boolean[n+1];
        //1不是prime，先假设剩下的都是prime
        for(int i =2;i<=n;i++) primes[i] = true;
        for (int i = 2; i * i < n; i++)
            if (primes[i])
                for (int j = i * i; j < n; j += i)
                    primes[j] = false;

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            if(i<=n-i && primes[i] && primes[n-i]){
                res.add(Arrays.asList(i,n-i));
            }
        }
        return res;
    }
}
