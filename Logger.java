import java.util.*;
public class Logger {
  Map<String, Integer> map;
  public Logger() {
      map = new HashMap();
  }
  
  public boolean shouldPrintMessage(int timestamp, String message) {
      boolean ans;
      if (map.containsKey(message)) {
          if (map.get(message) > timestamp) {
              return false;
          }
          else {
              ans = true;
          }
      }
      else {
          ans = true;
      }
      map.put(message, timestamp+10);
      return ans;
  }
}
