package greedy;

class SmallestStringSolution {
    public String smallestString(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0;i<s.length();i++){
            if(chars[i] >'a'){
                //找到第一个a
                while(i<s.length() && chars[i] >'a'){
                    chars[i]--;
                    i++;
                }

                return new String(chars);
            }
        }
        chars[s.length()-1] = 'z';
        return new String(chars);

    }
}
