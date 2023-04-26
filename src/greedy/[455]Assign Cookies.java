package greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;

        while(i<g.length&&j<s.length){
            if(g[i]<=s[j]) i++;
            j++;
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
