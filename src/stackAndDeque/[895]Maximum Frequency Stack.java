package stackAndDeque;

import java.util.*;

class FreqStack {
    Map<Integer,Integer> freq;
    List<ArrayDeque<Integer>> freqGroup;
    int maxFreq = 0;
    public FreqStack() {
        freq = new HashMap<>();
        freqGroup = new ArrayList<>();
    }

    public void push(int val) {
        int f = freq.getOrDefault(val,0)+1;
        freq.put(val, f);
        if(f>maxFreq) maxFreq = f;
        //这里用while是因为频率是从1开始的，但我们的List初始化以后没有对0的情况添加stack，所以就用while防止出界
        //也可以在前面constructor为0加一个stack，但即使我们在这里用while，除了第一次push会循环两次，其他情况和if是一样的效果
        while(freqGroup.size()-1<=f){
            freqGroup.add(new ArrayDeque<>());
        }
        freqGroup.get(f).push(val);
    }

    public int pop() {
        int x = freqGroup.get(maxFreq).pop();
        freq.put(x, freq.get(x)-1);
        if(freqGroup.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return x;
    }
}
