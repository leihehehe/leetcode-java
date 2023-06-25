package weeklyContest;

class BeautifulIndexPairs {
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        for(int i = 0;i<nums.length-1;i++){
            int first = nums[i];
            while(first>=10) first = first/10;
            for(int j = i+1;j<nums.length;j++){
                int last = nums[j]%10;
                if(gcd(first,last)==1){
                    count++;
                }
            }
        }
        return count;

    }
    public int gcd(int x, int y){
        while(y!=0){
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    public static void main(String[] args) {
        BeautifulIndexPairs beautifulIndexPairs = new BeautifulIndexPairs();
        System.out.println(beautifulIndexPairs.countBeautifulPairs(new int[]{2, 5, 1, 4}));
    }
}
