package others;

import java.util.ArrayList;
import java.util.List;

/***
 * LeetCode 89
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> results = new ArrayList<>();
        results.add(0);
        if(n ==0){
            return results;
        }
        int first=1;
        for(int i=0;i<n;i++){
            for(int j= results.size()-1;j>=0;j--){
                results.add(first+ results.get(j));
            }
            first=first<<1;
        }
        return results;
    }

}
