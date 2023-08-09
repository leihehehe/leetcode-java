package doublePointer;

//leetcode submit region begin(Prohibit modification and deletion)
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        //area = width * min(height[l],height[r])
        int l = 0, r = height.length-1;
        int area = 0;
        while(l<r){
            area = Math.max((r-l) * Math.min(height[l],height[r]),area);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
