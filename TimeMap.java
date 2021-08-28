import java.util.*;
public class TimeMap {
    class Pair {
      String val;
      int time;
      
      public Pair(String val, int time) {
          this.val = val;
          this.time = time;
      }
  }

  Map<String, List<Pair>> map;
  /** Initialize your data structure here. */
  public TimeMap() {
      map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
      Pair p = new Pair(value, timestamp);
      List<Pair> list;
      if (map.containsKey(key)) {
          list = map.get(key);
      }
      else {
          list = new ArrayList<>();
      }
      list.add(p);
      map.put(key, list);
  }

  public String get(String key, int timestamp) {
      
      if (map.containsKey(key)) {
          List<Pair> list = map.get(key);
          for (int i=list.size()-1; i>=0; i--) {
              Pair p = list.get(i);
              if (p.time <= timestamp) {
                  return p.val;
              }
          }            
      }
      return "";
  }
}
