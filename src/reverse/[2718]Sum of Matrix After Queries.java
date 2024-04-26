package reverse;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class MatrixSumQueries {
    public long matrixSumQueries(int n, int[][] queries) {
        Set<Integer>[] sets = new Set[]{new HashSet<>(), new HashSet<>()};
        long sum = 0;
        for(int i = queries.length-1;i>=0;i--){
            var query = queries[i];
            int type = query[0];
            int index = query[1];
            int val = query[2];
            if(!sets[type].contains(index)){
                //减去这一行操作过的列的个数/减去这一列操作过的行数
                sum += (long) (n - sets[type ^ 1].size()) * val;
                sets[type].add(index);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
