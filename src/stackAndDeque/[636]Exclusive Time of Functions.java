package stackAndDeque;

import java.util.ArrayDeque;
import java.util.List;

class ExclusiveTimeSolution {
    public int[] exclusiveTime(int n, List<String> logs) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[n];
        int prevTime = 0;
        for(String log: logs){
            String[] splittedLog = log.split(":");
            int id = Integer.parseInt(splittedLog[0]);
            int timestamp = Integer.parseInt(splittedLog[2]);
            if(splittedLog[1].equals("start")){
                //start的话可以更新前一个任务的时间 = 当前时间 - 上一次函数执行完毕的时间
                if(!stack.isEmpty()){
                    int[] prev = stack.peek();
                    res[prev[0]] += timestamp - prevTime;
                }
                stack.push(new int[]{id,timestamp});
                prevTime = timestamp;
            }else{
                //end的话可以更新当前任务的时间 = 当前时间 - 上一次函数执行完毕的时间
                int[] prev = stack.pop();
                res[prev[0]] += timestamp - prevTime + 1;
                prevTime = timestamp + 1;
            }
        }
        return res;
    }
}
