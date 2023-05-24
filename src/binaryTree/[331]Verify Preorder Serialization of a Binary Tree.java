package binaryTree;

//leetcode submit region begin(Prohibit modification and deletion)
class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        int degree = 1;
        for(String s :preorder.split(",")){
            if(s.equals("#")){
                degree--;
                if(degree<0){
                    return false;
                }
            }else{
                degree--;
                if(degree<0){
                    return false;
                }
                degree+=2;
            }
        }
        return degree==0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
