package prefixSumAndDifference;

import java.util.*;

class BeautifulSubstringsSolution {
    public long beautifulSubstrings(String s, int k) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.addAll(Arrays.asList('a','e','i','o','u'));
        List<Integer> wList = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            if(i*i%k ==0 ) wList.add(i);
        }
        HashMap<String,Integer> map = new HashMap<>();
        long sum = 0L;
        long res = 0;
        long vowelCount = 0;
        map.put(generateKey(sum,0), 1);
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(vowels.contains(c)){
                sum+=1;
                vowelCount++;
            }else{
                sum-=1;
            }
            for(int w : wList){
                res+=map.getOrDefault(generateKey(sum, (vowelCount-w+k)%k),0);
            }
            String key = generateKey(sum, vowelCount%k);
            map.merge(key, 1,Integer::sum);
        }
        return res;
    }
    public String generateKey(long sum, long vowelCount){
        return sum+":"+vowelCount;
    }
}