package binarySearch;

import java.util.Arrays;

class FindRadiusSolution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max = Math.max(houses[houses.length-1],heaters[heaters.length-1]);
        int l = 0, r = max;
        while(l<r){
            int mid = (l+r)/2;
            if(check(houses,heaters,mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    public boolean check(int[] houses, int[] heaters, int r){
        int i = 0, j = 0;
        while(i<houses.length && j<heaters.length){
            int house = houses[i];
            int heater = heaters[j];
            if(house<=heater+r && house>=heater-r){
                i++;
            }else{
                j++;
            }
        }
        return i==houses.length;
    }
}
