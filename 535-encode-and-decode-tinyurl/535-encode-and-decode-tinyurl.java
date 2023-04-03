public class Codec {
    HashMap<String,String> encode = new HashMap<>(), decode = new HashMap<>();
    final String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String getCode(){
        int[] ch = new int[6];
        for(int i=0;i<6;i++){
            ch[i] = str.charAt((int)Math.random() * 62);
        }
        String res = "http://tinyurl.com/" + String.valueOf(ch);
        return res;
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(encode.containsKey(longUrl))  return encode.get(longUrl);
        String code = getCode();
        while(decode.containsKey(code))  code=getCode();
        encode.put(longUrl,code);
        decode.put(code,longUrl);
        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decode.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));