import java.util.*;

public class Test {
    public static void main(String[] args) {
        getSmallestString("xaxcd",4);

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
