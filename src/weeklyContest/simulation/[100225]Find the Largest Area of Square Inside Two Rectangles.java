package weeklyContest.simulation;

/**
 * Medium
 * Weekly Contest 386
 */
class LargestSquareArea {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long res = 0;
        for(int i = 0;i<n-1;i++){
            long leftBottomX1 = bottomLeft[i][0];
            long leftBottomY1 = bottomLeft[i][1];
            long topRightX1 = topRight[i][0];
            long topRightY1 = topRight[i][1];
            for(int j = i+1;j<n;j++){
                long leftBottomX2 = bottomLeft[j][0];
                long leftBottomY2 = bottomLeft[j][1];
                long topRightX2 = topRight[j][0];
                long topRightY2 = topRight[j][1];

                long iLeftBottomX = Math.max(leftBottomX1, leftBottomX2);
                long iLeftBottomY = Math.max(leftBottomY1, leftBottomY2);
                long iTopRightX = Math.min(topRightX1,topRightX2);
                long iTopRightY = Math.min(topRightY1,topRightY2);
                if(iLeftBottomX>iTopRightX || iLeftBottomY>iTopRightY){
                    continue;
                }
                long width = Math.min(iTopRightY-iLeftBottomY,iTopRightX-iLeftBottomX);
                res = Math.max(res,width*width);
            }
        }
        return res;
    }
}