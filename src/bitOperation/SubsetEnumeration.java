package bitOperation;

import java.util.ArrayList;
import java.util.List;

public class SubsetEnumeration {
    public static void main(String[] args) {
        int[] set = {1,2,3};
        int n = set.length;
        for(int i = 0;i<(1<<n);i++){
            List<Integer> subset = new ArrayList<>();
            for(int j = 0;j<n;j++){
                //
                if((i&(1<<j))!=0){
                    subset.add(set[j]);
                }
            }
            System.out.println(subset);
        }
    }
}
