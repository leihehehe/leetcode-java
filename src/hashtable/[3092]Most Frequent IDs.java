package hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Weekly Contest 390
 * Medium
 */
class MostFrequentIDsSolution1 {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        //Method 1: treemap+hashmap
        //id -> freq
        Map<Integer,Long> map = new HashMap<>();
        //freq -> times of freq appearing
        TreeMap<Long,Integer> treeMap = new TreeMap<>();
        int n = nums.length;
        long[] res = new long[n];
        for(int i = 0;i<n;i++){
            int id = nums[i];
            int change = freq[i];
            long oldFreq = map.getOrDefault(id,0l);
            long newFreq = oldFreq+change;
            //update treeMap
            if(treeMap.containsKey(oldFreq)){
                treeMap.put(oldFreq,treeMap.get(oldFreq)-1);
                if(treeMap.get(oldFreq)==0){
                    treeMap.remove(oldFreq);
                }
            }

            map.put(id,newFreq);
            treeMap.put(newFreq,treeMap.getOrDefault(newFreq,0)+1);
            res[i] = treeMap.lastKey();
        }
        return res;
    }
}
class MostFrequentIDsSolution2 {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        //Method 2: hashmap+priority queue(max heap)
        //id -> freq
        Map<Integer,Long> map = new HashMap<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b)->Long.compare(b.getFreq(),a.getFreq()));

        int n = nums.length;
        long[] res = new long[n];
        for(int i = 0;i<n;i++){
            int id = nums[i];
            int change = freq[i];
            map.put(id,map.getOrDefault(id,0l)+change);
            maxHeap.add(new Pair(id,map.get(id)));
            //No need to check if heap is empty
            while(!map.get(maxHeap.peek().getId()).equals(maxHeap.peek().getFreq())){
                maxHeap.poll();
            }
            res[i] = maxHeap.peek().getFreq();
        }
        return res;
    }
    class Pair{
        int id;
        long freq;

        public Pair(int id, long freq) {
            this.id = id;
            this.freq = freq;
        }

        public int getId() {
            return id;
        }

        public long getFreq() {
            return freq;
        }
    }
}