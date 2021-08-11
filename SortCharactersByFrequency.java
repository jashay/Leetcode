import java.util.*;
public class SortCharactersByFrequency {
  private class Pair {
    int count;
    char c;
    public Pair(char c, int count) {
        this.c = c;
        this.count  = count;
    }
}

public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    List<Pair> list = new ArrayList<>();
    for (char c : s.toCharArray()) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c)+1);
        }
        else {
            map.put(c, 1);
        }
    }
    
    for (char c : map.keySet()) {
        Pair p = new Pair(c, map.get(c));
        list.add(p);
    }
    
    Collections.sort(list, (a,b) -> b.count - a.count);
    
    StringBuilder sb = new StringBuilder();
    
    for (Pair p : list) {
        int count = p.count;
        while (count >0) {
            sb.append(p.c);
            count--;
        }
    }
    
    return sb.toString();
  } 
}
