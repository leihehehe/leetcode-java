package design;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Codec {
    private HashMap<String,String> map = new HashMap<>();
    private static final String PREFIX = "http://tinyurl.com/";
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String[] str = longUrl.split("/");
        String code = str[str.length-1];
        int hash = Objects.hash(code);
        String encodedCode = base62Encode(hash);
        map.put(encodedCode,longUrl);
        return PREFIX+encodedCode;

    }

    public static String base62Encode(int value){
        StringBuilder sb = new StringBuilder();
        while(value!=0){
            sb.append(BASE62.charAt(value%62));
            value/=62;
        }
        return sb.reverse().toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] str = shortUrl.split("/");
        String code = str[str.length-1];
        return map.get(code);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String encode = codec.encode("http://baidu.com/shulei123213asdsadwadwqd");
        System.out.println(encode);
        System.out.println(codec.decode(encode));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
//leetcode submit region end(Prohibit modification and deletion)
