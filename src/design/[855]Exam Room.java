package design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class ExamRoom {
    private Map<Integer,int[]> startMap;
    private Map<Integer,int[]> endMap;
    private TreeSet<int[]> pq;
    private int N;
    public ExamRoom(int n) {
        this.N = n;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        pq = new TreeSet<>((a,b)->{
            int distA = distance(a);
            int distB = distance(b);
            //从大到小排列
            if(distA == distB)
                return b[0] - a[0];
            //从小到大排列
            return distA - distB;
        });
        addInterval(new int[]{-1,N});
    }

    public int seat() {
        int[] longest = pq.last();
        int start = longest[0];
        int end = longest[1];
        int seat;
        //情况一，没有位置，选择第一个位置
        if(start == -1){
            seat = 0;
        }else if(end == N){
            //情况二，选了第一个位置，选最后一个位置
            seat = N -1;
        }else{
            //情况三，中间位置，就是距离+start index
            seat = (end-start)/2 + start;
        }
        int[] left = new int[]{start, seat};
        int[] right = new int[]{seat,end};
        //删除原来的线段
        removeInterval(longest);
        //增加新的两条线段
        addInterval(left);
        addInterval(right);
        return seat;
    }

    public void leave(int p) {
        //p位置左右的线条找出来，进行合并
        //p作为右端点的线段
        int[] right = startMap.get(p);
        //p作为左端点的线段
        int[] left = endMap.get(p);
        int[] merged = new int[]{left[0],right[1]};
        removeInterval(left);
        removeInterval(right);
        addInterval(merged);
    }

    public void addInterval(int[] intv){
        pq.add(intv);
        startMap.put(intv[0],intv);
        endMap.put(intv[1],intv);
    }

    public void removeInterval(int[] intv){
        pq.remove(intv);
        startMap.remove(intv[0]);
        endMap.remove(intv[1]);
    }

    //计算线段长度
    private int distance(int[] intv){
        int start = intv[0];
        int end = intv[1];
        if(start == -1) return end;
        if(end == N) return N-start-1;
        return (end-start)/2;
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
//leetcode submit region end(Prohibit modification and deletion)
