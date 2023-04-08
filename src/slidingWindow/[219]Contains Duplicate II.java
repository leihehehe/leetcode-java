package slidingWindow;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int l = 0, r =0;
        while(r<nums.length){
            int toAdd = nums[r];
            r++;
            if(window.contains(toAdd)) return true;
            window.add(toAdd);
            while(r-l>k){
                int toRemove = nums[l];
                l++;
                if(window.contains(toRemove)) window.remove(toRemove);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
