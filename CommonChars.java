import java.util.*;
public class CommonChars {
  public List<String> commonChars(String[] words) {
    Map<Character, Integer> map = new HashMap<>();
    
    for (char c : words[0].toCharArray()) {
        map.put(c, map.getOrDefault(c,0)+1);
    }
    
    for (String word : words) {
        Map<Character, Integer> newMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            newMap.put(c, newMap.getOrDefault(c,0)+1);
        }
        List<Character> listToRemove = new ArrayList<>();
        for (char x : map.keySet()) {
            if (!newMap.containsKey(x)) {
                listToRemove.add(x);
            }
            else {
                map.put(x, Math.min(map.get(x), newMap.get(x)));                    
            }
        }
        for (char y : listToRemove) {
            System.out.println(y);
            map.remove(y);
        }
    }
    List<String> ans = new ArrayList<>();
    for (char z : map.keySet()) {
        int count = map.get(z);
        while (count > 0) {
            ans.add(String.valueOf(z));
            count--;
        }
    }
    
    return ans;
}
}
