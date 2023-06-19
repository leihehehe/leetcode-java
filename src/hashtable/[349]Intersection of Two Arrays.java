package hashtable;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> record = new HashSet<>();
        Set<Integer> intersections = new HashSet<>();
        for(int num:nums1){
            record.add(num);
        }
        for(int num:nums2){
            if(record.contains(num))
                intersections.add(num);
        }
        int[] res = new int[intersections.size()];
        int i = 0;
        for(int num:intersections){
            res[i]=num;
            i++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
