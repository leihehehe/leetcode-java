package stackAndDeque;

import java.util.*;

class DinnerPlatesSolution1 {
    List<Deque<Integer>> stackList ;
    PriorityQueue<Integer> pq;
    int capacity;
    public DinnerPlatesSolution1(int capacity) {
        this.stackList = new ArrayList<>();
        this.capacity = capacity;
        //找到index最小的那一个
        this.pq = new PriorityQueue<>();
    }

    public void push(int val) {
        //lazy deletion
        //如果pq中非满栈的最小index比当前非空stack数量还多，直接清空即可。
        //如果pq中非满栈的最小index小于当前stack的数量，说明他是中间的栈（不是末尾的栈），所以直接在这个栈中push即可。
        if(!pq.isEmpty() && pq.peek()>=stackList.size())
            pq.clear();
        //所有栈都是full
        if(pq.isEmpty()){
            ArrayDeque<Integer> newStack = new ArrayDeque<>();
            newStack.push(val);
            stackList.add(newStack);
            int curSize = newStack.size();
            if(curSize<capacity){
                pq.offer(stackList.size()-1);
            }
        }else{
            var stackIndex = pq.poll();
            var curStack = stackList.get(stackIndex);
            curStack.push(val);
            int curSize = curStack.size();
            if(curSize<capacity){
                pq.offer(stackIndex);
            }
        }
    }

    public int pop() {
        return popAtStack(stackList.size()-1);
    }

    public int popAtStack(int index) {
        if(index>=stackList.size() || index<0) return -1;
        var curStack = stackList.get(index);
        if(curStack.isEmpty()) return -1;
        if(curStack.size() == capacity){
            //放入不满栈
            pq.add(index);
        }
        var val = curStack.pop();
        //移除stackList的末尾中的空栈，可以节省空间，而且方便直接get到最后一个非空栈
        while(!stackList.isEmpty() && stackList.get(stackList.size()-1).isEmpty()){
            stackList.remove(stackList.size()-1);
        }

        return val;
    }
}
class DinnerPlatesSolution2 {
    List<Deque<Integer>> stackList ;
    TreeSet<Integer> notFullStacks;
    int capacity;
    public DinnerPlatesSolution2(int capacity) {
        this.stackList = new ArrayList<>();
        this.capacity = capacity;
        //找到index最小的那一个
        this.notFullStacks = new TreeSet<>();
    }

    public void push(int val) {

        if(notFullStacks.isEmpty()){
            ArrayDeque<Integer> newStack = new ArrayDeque<>();
            newStack.push(val);
            stackList.add(newStack);
            int curSize = newStack.size();
            if(curSize<capacity){
                notFullStacks.add(stackList.size()-1);
            }
        }else{
            var stackIndex = notFullStacks.first();
            var curStack = stackList.get(stackIndex);
            curStack.push(val);
            int curSize = curStack.size();
            if(curSize==capacity){
                notFullStacks.remove(stackIndex);
            }
        }
    }

    public int pop() {
        return popAtStack(stackList.size()-1);
    }

    public int popAtStack(int index) {
        if(index>=stackList.size() || index<0) return -1;
        var curStack = stackList.get(index);
        if(curStack.isEmpty()) return -1;
        if(curStack.size() == capacity){
            //放入不满栈
            notFullStacks.add(index);
        }
        var val = curStack.pop();
        //移除stackList的末尾中的空栈，可以节省空间，而且方便直接get到最后一个非空栈
        //空栈在被remove之前肯定是在未满栈中，因为treeset会进行排序，因为我是从末尾开始remove空栈的，那么treeset也是以同样的顺序
        while(!stackList.isEmpty() && stackList.get(stackList.size()-1).isEmpty()){
            int lastIndex = stackList.size()-1;
            stackList.remove(lastIndex);
            notFullStacks.remove(lastIndex);
        }

        return val;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */