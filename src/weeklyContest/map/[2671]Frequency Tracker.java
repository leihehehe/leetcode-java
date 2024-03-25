package weeklyContest.map;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class FrequencyTracker {
    //number -> frequency
    HashMap<Integer,Integer> numMap;
    //frequency -> occurring times
    HashMap<Integer,Integer> freqMap;
    public FrequencyTracker() {
        numMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    /**
     * 1. update frequency in numMap +1
     * 2. update freqMap
     *      - oldFreq -1 => 0->remove
     *      - newFreq +1
     */
    public void add(int number) {
        int oldFreq = numMap.getOrDefault(number,0);
        int newFreq = oldFreq+1;
        numMap.put(number, newFreq);
        if(freqMap.containsKey(oldFreq)){
            freqMap.put(oldFreq, freqMap.get(oldFreq)-1);
            if(freqMap.get(oldFreq)==0){
                freqMap.remove(oldFreq);
            }
        }
        freqMap.put(newFreq,freqMap.getOrDefault(newFreq, 0)+1);
    }
    /**
     * 1. update frequency in numMap -1
     * 2. update freqMap
     *      - oldFreq -1 => 0->remove
     *      - newFreq +1
     */
    public void deleteOne(int number) {
        int oldFreq = numMap.getOrDefault(number,0);
        int newFreq = oldFreq-1;
        if(newFreq>=0){
            numMap.put(number, newFreq);
            if(freqMap.containsKey(oldFreq)){
                freqMap.put(oldFreq, freqMap.get(oldFreq)-1);
                if(freqMap.get(oldFreq)==0){
                    freqMap.remove(oldFreq);
                }
            }
            freqMap.put(newFreq,freqMap.getOrDefault(newFreq, 0)+1);
        }

    }

    public boolean hasFrequency(int frequency) {
        return freqMap.containsKey(frequency);
    }
}


/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
//leetcode submit region end(Prohibit modification and deletion)
