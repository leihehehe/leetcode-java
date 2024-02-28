package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class BestTeamScoreSolution1 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int m = ages.length;
        int n = scores.length;

        //if age[i]>age[j] -> score[i]>score[j]

        Integer[] ids = new Integer[m];

        for(int i = 0;i<n;i++){
            ids[i] = i;
        }
        Arrays.sort(ids,(i, j)->scores[i]!=scores[j]?scores[i]-scores[j]:ages[i]-ages[j]);
        int ans = 0;
        int[] f = new int[n+1];
        //当一名年龄较小球员的分数严格大于一名年龄较大的球员，则存在矛盾
        //条件就是年龄小的分数要<=年龄大的

        for(int i = 0;i<n;i++){
            //遍历ages,选得分sum最大的递增子序列
            for(int j = 0;j<i;j++){
                if(ages[ids[j]]<=ages[ids[i]]){
                    f[i] = Math.max(f[i],f[j]);
                }
            }
            f[i]+=scores[ids[i]];
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }
}
class BestTeamScoreSolution2 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int m = ages.length;
        int n = scores.length;

        //if age[i]>age[j] -> score[i]>score[j]

        Integer[] ids = new Integer[m];

        for(int i = 0;i<n;i++){
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) -> ages[i] != ages[j] ? ages[i] - ages[j] : scores[i] - scores[j]);
        int ans = 0;
        int[] f = new int[n+1];
        //当一名年龄较小球员的分数严格大于一名年龄较大的球员，则存在矛盾
        //条件就是年龄小的分数要<=年龄大的
        for(int i = 0;i<n;i++){
            //遍历ages,选得分sum最大的递增子序列
            for(int j = 0;j<i;j++){
                //年龄小
                if(scores[ids[j]]<=scores[ids[i]]){
                    f[i] = Math.max(f[i],f[j]);
                }
            }
            f[i]+=scores[ids[i]];
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
