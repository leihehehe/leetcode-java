package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class FindComplement {
    public int findComplement(int num) {
        //获取最高的1是多少位
        int bit = 1;
        while((num>>bit)>0){
            bit++;
        }
        //然后用mask来固定位数
        return ~num & ((1<<bit)-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
