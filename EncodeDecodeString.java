import java.util.*;
public class EncodeDecodeString {
  int counter =0;
  Map<Integer, String> map = new HashMap<>();
  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
      String ans = String.valueOf(counter);
      map.put(counter++, longUrl);
      return ans;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
      if (map.containsKey(Integer.parseInt(shortUrl))) {
          return map.get(Integer.parseInt(shortUrl));
      }
      
      return "";
  }
}
