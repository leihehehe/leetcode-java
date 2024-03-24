import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        mostFrequentIDs(new int[]{2,3,2,1},new int[]{3,2,-3,1});
    }
    class Frequency{
        int id;
        long freq;

        Frequency(long freq, int id) {
            this.freq = freq;
            this.id = id;
        }
    }
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        Map<Integer,Long> map =  new HashMap<>();
        PriorityQueue<Frequency> maxHeap = new PriorityQueue<>((a, b)->Long.compare(b.freq ,a.freq));
        int n = nums.length;
        long[] res = new long[n];
        long maxFreq = 0;
        for(int i = 0;i<n;i++){
            int id = nums[i];
            long count = freq[i];
            map.put(id,map.getOrDefault(id,0l)+count);
            maxHeap.add(new Frequency(map.get(id),id));
            if(map.get(id)==0){
                map.remove(id);
                if(maxHeap.peek().id == id){
                    maxHeap.poll();
                }
            }
            if (!map.isEmpty()) {
                while(!map.containsKey(maxHeap.peek().id)){
                    maxHeap.poll();
                }
                maxFreq = maxHeap.peek().freq;
            } else {
                maxFreq = 0;
            }

            res[i] = maxFreq;

        }
        return res;
    }
    public static int minOperations(int k) {
        //[1]
        //1+1+1+1+1+1+1+1+1+1+1
        //binary search
        //1+1+1+1+4+4 => 5次
        int l = 0, r = k-1;
        while(l<r){
            int mid = l+r>>1;
            if(check(mid,k)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return check(l,k)?l:l+1;
    }
    public static boolean check(int mid,int k){
        //变成一个大的数x需要x-1次
        //剩下次数：mid-(x-1)次
        //答案：x+x*(mid-(x-1))
        //5次
        //1+ 1+1+1+1+5 = 10
        //1+ 1+1+1+4+4 = 13
        //1+ 1+1+3+3+3 = 12
        //[4,4,4]
        for(int i = k;i>0;i--){

            int ops = mid;
            int need1 = i-1;
            int need2 = ops - need1;
            int sum = i+i*need2;
            if(sum<k){
                continue;
            }
            if(need1>ops){
                continue;
            }
            ops-=need1;
            if(need2>ops){
                continue;
            }
            return true;
        }
        return false;


    }
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int unmeet= 0;
        int l = 0, r = 0;
        int max=0;
        //[l,r)
        while(r<s.length()){
            char toAdd = s.charAt(r);
            r++;
            map.put(toAdd,map.getOrDefault(toAdd,0)+1);
            if(map.get(toAdd)==3){
                unmeet++;
            }
            while(unmeet>0){
                char toRemove = s.charAt(l);
                l++;
                map.put(toRemove,map.get(toRemove)-1);
                if(map.get(toRemove)==0){
                    map.remove(toRemove);
                }else if(map.get(toRemove)==2){
                    unmeet--;
                }
            }
            max = Math.max(r-l,max);
        }
        return max;
    }
    public static int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int n1 = 0;
        arr1[n1] = nums[0];
        int[] arr2 = new int[n];
        int n2 = 0;
        arr2[n2] = nums[1];
        int[] res = new int[n];
        for(int i = 2;i<n;i++){
            if(arr1[n1]>arr2[n2]){
                arr1[++n1] = nums[i];
            }else{
                arr2[++n2] = nums[i];
            }
        }
        int end = 0;
        for(int i = 0;i<=n1;i++){
            res[i] = arr1[i];
            end = i;
        }
        end+=1;
        for(int i = 0;i<=n2;i++){
            res[end++] = arr2[i];
        }
        return res;
    }
}
