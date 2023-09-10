package binarySearch;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * follow-up question of LC392
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
 * and you want to check one by one to see if t has its subsequence.
 * In this scenario, how would you change your code?
 */
class IsSubsequenceChallenge {
    ArrayList<Integer>[] map = new ArrayList[256];
    /**
     * Initialization
     * @param sn
     * @param t
     */
    public IsSubsequenceChallenge(String[] sn, String t){
        for(int i = 0;i<t.length();i++){
            char c = t.charAt(i);
            if(map[c] == null){
                map[c] = new ArrayList<>();
            }
            map[c].add(i);
        }
        for(String word:sn){
            System.out.println(isSubsequence(word, t));
        }
    }

    public boolean isSubsequence(String s, String t){
        int m = s.length();
        int j = 0;
        for(int i = 0;i<m;i++){
            char c = s.charAt(i);
            if(map[c]==null) return false;
            int pos = search(map[c],j);
            if(pos==-1){
                return false;
            }
            j = map[c].get(pos)+1;
        }
        return true;
    }
    //[1,2,4]
    //找第一个大于等于target的数
    public int search(ArrayList<Integer> arr, int target){
        int l = 0, r = arr.size()-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(arr.get(mid)>=target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        //没有第一个大于等于target的数
        if(l>=arr.size()){
            return -1;
        }
        return l;
    }

    public static void main(String[] args) {
        var test = new IsSubsequenceChallenge(new String[]{"ace","dfg","vdas"},"abcdefg");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
