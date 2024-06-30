package math;

class MaxHeightOfTriangleSolution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(calculate(red, blue), calculate(blue, red));
    }

    private int calculate(int m, int n) {
        var odd = (int) Math.sqrt(m);
        var even = (int) ((Math.sqrt(1 + 4 * n) - 1) / 2);
        return odd <= even ? odd * 2 : even * 2 + 1;
    }
}

class MaxHeightOfTriangleSolution2 {

    public int maxHeightOfTriangle(int red, int blue) {

        return Math.max(cal(blue, red), cal(red, blue));
    }

    public int cal(int odd, int even) {
        for (int i = 1; ; i++) {
            if (i % 2 == 0) {
                even -= i;
            } else {
                odd -= i;
            }
            if (odd < 0 || even < 0) {
                return i - 1;
            }
        }
    }

}
