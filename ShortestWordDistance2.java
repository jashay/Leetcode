import java.util.*;
public class ShortestWordDistance2 {
  Map<String, List<Integer>> map;
  public ShortestWordDistance2(String[] wordsDict) {
      map = new HashMap();
      
      for (int i=0; i<wordsDict.length; i++) {
          String word = wordsDict[i];
          List<Integer> l;
          if (map.containsKey(word)) {
              l = map.get(word);
          }
          else {
              l = new ArrayList();
          }
          l.add(i);
          map.put(word, l);
      }
    }
    
  public int shortest(String word1, String word2) {
    List<Integer> l1 = map.get(word1);
    List<Integer> l2 = map.get(word2);
    int min = Integer.MAX_VALUE;
    for (int x: l1) {
        for (int y : l2) {
            min = Math.min(min, Math.abs(x-y));
        }
    }
    return min;
  }
}
