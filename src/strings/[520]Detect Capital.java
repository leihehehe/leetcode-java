package strings;

class DetectCapitalUseSolution {
    public boolean detectCapitalUse(String word) {
        int countUpper = 0;
        boolean firstUpperCase = false;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(Character.isUpperCase(c)){
                if(i==0) firstUpperCase = true;
                countUpper++;
            }
        }
        return countUpper==0 || countUpper ==word.length() || (firstUpperCase && countUpper == 1);
    }
}
