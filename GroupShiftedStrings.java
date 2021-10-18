import java.util.*;
public class GroupShiftedStrings {
  public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> ans = new ArrayList();
    Map<String, List<String>> map = new HashMap();
    
    for (String s : strings) {
        String key = "0+";
        char c = s.charAt(0);
        for (int i=1; i<s.length(); i++) {
            int diff = s.charAt(i) - c;
            if (diff <0) diff+= 26;
            key += diff+"+";
            c = s.charAt(i);
        }
        
        map.putIfAbsent(key, new ArrayList());
        map.get(key).add(s);
    }

    ans.addAll(map.values());
    return ans;
}
}
