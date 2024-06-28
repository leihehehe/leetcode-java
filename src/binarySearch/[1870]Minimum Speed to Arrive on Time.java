package binarySearch;

class MinSpeedOnTimeSolution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = (int)1e7;
        while(l<r){
            int mid = (l+r)/2;
            if(check(dist,hour,mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return check(dist,hour,l)?l:-1;
    }
    public boolean check(int[] dist, double hour, int speed){
        double actualHour = 0;
        for(int i = 0;i<dist.length;i++){
            int d = dist[i];
            if(i==dist.length-1){
                //注意这里要double 否则是先按int进行运算最后在赋值给double类型的
                double h = (double)d/speed;
                actualHour+=h;
            }else{
                int h = (d-1+speed)/speed;
                actualHour+=h;
            }
        }
        return actualHour<=hour;
    }
}
