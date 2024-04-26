package binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class SnapshotArray {
    //index -> [0,1,2,3]
    Map<Integer, ArrayList<int[]>> map;
    int version = 0;
    public SnapshotArray(int length) {
        map = new HashMap<>();
    }

    public void set(int index, int val) {
        if(!map.containsKey(index)){
            map.put(index, new ArrayList<>());
        }
        ArrayList<int[]> vals = map.get(index);
        vals.add(new int[]{version,val});
    }

    public int snap() {
        return version++;
    }

    public int get(int index, int snap_id) {
        //[{0,2},{0,3},{1,2},{1,3}]
        if(!map.containsKey(index)) return 0;
        List<int[]> history = map.get(index);
        int l = 0, r = history.size()-1;
        while(l<r){
            int mid = (l+r+1)>>1;
            if(history.get(mid)[0]<=snap_id){
                l = mid;
            }else{
                r = mid-1;
            }
        }
        int ver = history.get(l)[0];
        int record = history.get(l)[1];
        //这里之所以是<=，因为创建snap后，可能这个snap还没有被修改，所以没有新的被添加（实际和上一个版本相同），因此需要找小于等于的版本。
        return ver<=snap_id?record:0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
//leetcode submit region end(Prohibit modification and deletion)
