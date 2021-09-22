import java.util.*;
public class ShortestWordDistance3 {
  public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
    Map<String, List<Integer>> map = new HashMap();
    
    for (int i=0; i<wordsDict.length; i++) {
        String s = wordsDict[i];
        List<Integer> list;
        if (map.containsKey(s)) {
            list = map.get(s);
        }
        else {
            list = new ArrayList();
        }
        list.add(i);
        map.put(s, list);
    }
    
    List<Integer> loc1 = map.get(word1);
    List<Integer> loc2 = map.get(word2);
    int l1 = 0, l2 = 0;
    int min = Integer.MAX_VALUE;
    while (l1<loc1.size() && l2<loc2.size()) {
        if (loc1.get(l1) == loc2.get(l2)) {
            l1++;
            continue;
        }
        min = Math.min(min, Math.abs(loc1.get(l1) - loc2.get(l2)));
    
        if (loc1.get(l1) < loc2.get(l2)) {
            l1++;
        }
        else {
            l2++;
        }
    }
    
    return min;
}
}
