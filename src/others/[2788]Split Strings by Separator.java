package others;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SplitStringsBySeparator {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for(String word:words){
            String[] splits = word.split("\\"+separator);;
            for(String split: splits){
                if(!split.isEmpty()){
                    res.add(split);
                }

            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
