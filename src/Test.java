import java.util.*;

public class Test {
    public static void main(String[] args) {
        calculateMaxManhattanDistance(new int[][]{3,10});
    }
//[0,1,0] => 3
    //[0],[1],[0],[0,1],[1,0],[0,1,0] => 6
    //[0,1] => [0],[1],[0,1] => 2+1
    //3+2+1
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
