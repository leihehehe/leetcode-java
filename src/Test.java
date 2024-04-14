import java.util.*;

public class Test {
    static class Coin{
        int coinValue;
        long currentValue;
        public Coin(int coinValue, long currentValue){
            this.coinValue = coinValue;
            this.currentValue = currentValue;
        }
    }
    public static void main(String[] args) {
        char c = 'z';
        System.out.println('a'-c+26);
//        getSmallestString("xaxcd",4);
//        System.out.println(findKthSmallest(new int[]{6,5},1435065516));
    }
    public static long findKthSmallest(int[] coins, int k) {
        //3*1,3*2,3*3,3*4,3*5,3*6,3*7
        //3*2,3*4,3*6,3*8,3*10,3*12,3*14
        //3*3,3*6,3*9,3*12,
        int n = coins.length;
        Arrays.sort(coins);
        List<Integer> newNums = new ArrayList<>();
        PriorityQueue<Coin> minHeap = new PriorityQueue<>((a,b)->Long.compare(a.currentValue,b.currentValue));
        Set<Long> seen = new HashSet<>();
        newNums.add(coins[0]);
        minHeap.add(new Coin(coins[0],(long)coins[0]));
        for(int i = 0;i<n;i++){
            for(int j = 0;j<newNums.size();j++){
                if(coins[i]% newNums.get(j)==0){
                    continue;
                }else{
                    newNums.add(coins[i]);
                    minHeap.add(new Coin(coins[i],(long)coins[i]));
                }
            }
        }

        long kthMin = 0;

        while(k>0) {
            Coin currentCoin = minHeap.poll();
            if(!minHeap.isEmpty() && seen.contains(currentCoin.currentValue)){
                //do nothing
            }else{
                kthMin = currentCoin.currentValue;
                seen.add(currentCoin.currentValue);
                k--;
            }
            long nextVal = currentCoin.currentValue+currentCoin.coinValue;
            minHeap.add(new Coin(currentCoin.coinValue, nextVal));
        }
        return kthMin;
        //2,5
        //2*1,2*2,2*3,2*4,2*5,2*6
        //5*1,5*2,5*3,5*4

        //2*1,2*2,5*1,2*3,2*4,2*5,5*2,2*6

    }
    //3,6,9,12,15,18 => 6
    //6,12,18,24 => 3
    //9,18,27,36 => 2
    //3,6,9,12,15,18

    //5,2
    //5,10,15,20
    //2,4,6,8,10,12
    public static int maximumPrimeDifference(int[] nums) {
        int n = nums.length;

        int max = nums[0];
        for(int i = 0;i<n;i++){
            max = Math.max(max,nums[i]);
        }
        boolean[] primes = new boolean[max+1];
        Arrays.fill(primes,true);
        for(int i = 2; i*i<max+1;i++){
            if(primes[i]){
                for(int j = i*i;j<n;j+=i)
                    primes[j]=false;
            }
        }
        int firstPrime = -1;
        int lastPrime=-1;
        for(int i = 0;i<n;i++){
            if(primes[i] && firstPrime==-1){
                firstPrime = i;
            }
            if(primes[i]){
                lastPrime = i;
            }
        }
        if (firstPrime != -1 && lastPrime != -1) {
            return lastPrime - firstPrime;
        }
        return 0;

    }

    public static String findLatestTime(String s) {
        //11
        //09
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c!='?') sb.append(c);
            else if (i==1){
                if(sb.charAt(0)=='0'){
                    sb.append('9');
                }else if(sb.charAt(0)=='1'){
                    sb.append('1');
                }
            }else if(i==0){
                if(s.charAt(1)!='?' && s.charAt(1)>'1'){
                    sb.append('0');
                }else{
                    sb.append('1');
                }
            }else if(i==3){
                sb.append("5");
            }else if(i==4){
                sb.append("9");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String getSmallestString(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length && k > 0; i++) {
            int distance = chars[i] - 'a';
            // 字符到'a'的直接距离和循环距离
            int directDistance = distance;
            int loopDistance = 26 - distance;

            // 选择最小距离
            int minDistance = Math.min(directDistance, loopDistance);

            // 如果剩余的k足够减小距离
            if (k >= minDistance) {
                chars[i] = 'a'; // 将当前字符变为'a'
                k -= minDistance; // 更新剩余的k
            } else {
                // 距离不够，只能减少部分距离
                if (directDistance < loopDistance) {
                    chars[i] -= k;
                } else {
                    chars[i] += k;
                }
                k = 0; // k已经用完
            }
        }

        return new String(chars);
    }
    StringBuilder sb = new StringBuilder();
    String res;
    public void dfs(int i, String s, int k, int sum){
        if(i==s.length()){
            if(sum <= k && res.compareTo(sb.toString())>0)
                res = sb.toString();
            return;
        }
        char c = s.charAt(i);
        //keep or not keep
        sb.append(c);
        dfs(i+1,s,k,sum);
        sb.deleteCharAt(sb.length()-1);
        //not keep, choose other letters
        for(int j = 0;j<=25;j++){
            int curSum = Math.min(Math.abs(c-'a'-j),Math.abs(c-'a'+26-j));
            if(j==c-'a') continue;
            if(sum+curSum>k) continue;
            sb.append(j);
            dfs(i+1,s,k,sum+curSum);
            sb.deleteCharAt(sb.length()-1);
        }

    }
public static int longestMonotonicSubarray(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp,1);
    for(int i = 1;i<n;i++){
        if(nums[i] == nums[i-1]+1){
            dp[i] = dp[i-1]+1;
        }else{
            dp[i] = 1;
        }

    }
    int max = 0;
    for(int num:dp){
        max = Integer.max(max,num);
    }
    return max;
}
public int minimumDistance(int[][] points) {
    List<Integer> t1 = new ArrayList<>();
    List<Integer> t2 = new ArrayList<>();
    for (int i = 0;i<points.length;i++) {
        int[] point = points[i];
        t1.add(point[0] - point[1]);
        t2.add(point[0] + point[1]);
    }
    Collections.sort(t1);
    Collections.sort(t2);

    int res = Integer.MAX_VALUE;
    for(int i = 0;i<points.length;i++){
        int[] point = points[i];
        int curT1 = point[0] - point[1];
        int curT2 = point[0] - point[1];
        int n1 = t1.size()-1;
        int n2= 0;
        int x1 = t1.get(n1);
        int x2 = t1.get(n2);
        while(x1!=curT1)  x1 = t1.get(--n1);
        while(x2!=curT1)  x2 = t1.get(++n2);
        int m1 = t2.size()-1;
        int m2= 0;
        int y1 = t2.get(m1);
        int y2 = t2.get(m2);
        while(y1!=curT1)  y1 = t2.get(--m1);
        while(y2!=curT1)  t2.get(++m2);
        res = Math.min(Math.max(t1.get(t1.size() - 1) - t1.get(0), t2.get(t2.size() - 1) - t2.get(0)),res);
    }
    return res;
}


public long countAlternatingSubarrays(int[] nums) {
    int l = 0, r = 0;
    int n = nums.length;
    //[l,r)
    int prev = -1;
    long res = 0;
    while(r<n){
        int toAdd = nums[r];
        r++;
        //[1,1,1,0]
        if(prev!=toAdd){
            //继续往后移动
            prev = toAdd;
        }else{
            //一样，左移
            long sz = r-l;
            res+= (sz*(sz-1))/2;
            prev = -1;
            l++;
        }
    }
    return res;
}
}
