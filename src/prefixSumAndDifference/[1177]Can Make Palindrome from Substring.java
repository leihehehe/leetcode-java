package prefixSumAndDifference;

import java.util.ArrayList;
import java.util.List;

class CanMakePaliQueriesSolution1 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = queries.length;
        List<Boolean> ans = new ArrayList<>();
        //[1,1,1,1,1]
        //奇数freq的个数
        //偶数长度->每个字母的freq都必须是偶数
        //奇数长度->有一个字母的freq是奇数，其他都必须是偶数
        //更换一次->偶数+1，奇数-1
        int[][] freqMap = new int[s.length()+1][26];
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            freqMap[i+1] = freqMap[i].clone();
            freqMap[i+1][c-'a']++;
        }
        for(int i = 0;i<n;i++){
            int[] query = queries[i];
            var odd=0;
            for(int j =0;j<26;j++){
                var freq = freqMap[query[1]+1][j] - freqMap[query[0]][j];
                if(freq % 2 !=0){
                    odd++;
                }
            }
            ans.add(odd/2 <= query[2]);

        }
        return ans;
    }
}
class CanMakePaliQueriesSolution2 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = queries.length;
        List<Boolean> ans = new ArrayList<>();
        int[][] freqMap = new int[s.length()+1][26];
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            freqMap[i+1] = freqMap[i].clone();
            //只需要统计奇偶
            freqMap[i+1][c-'a']^=1;//偶数变奇数，奇数变偶数
        }
        for(int i = 0;i<n;i++){
            int[] query = queries[i];
            var odd=0;
            for(int j =0;j<26;j++){
                //奇数-奇数=偶数
                //偶数-偶数=偶数
                //奇数-偶数=奇数
                //偶数-奇数=奇数
                //所以两个数不一样答案就是奇数
                odd+= freqMap[query[1]+1][j] ^ freqMap[query[0]][j];
            }
            ans.add(odd/2 <= query[2]);
        }
        return ans;
    }
}