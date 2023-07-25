package design;

import java.util.HashMap;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Codec {
    private HashMap<String,String> map = new HashMap<>();
    private static final String PREFIX = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String[] str = longUrl.split("/");
        String code = str[str.length-1];
        String encodedCode = String.valueOf(Objects.hash(code));
        map.put(encodedCode,longUrl);
        return PREFIX+encodedCode;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] str = shortUrl.split("/");
        String code = str[str.length-1];
        return map.get(code);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
//leetcode submit region end(Prohibit modification and deletion)
