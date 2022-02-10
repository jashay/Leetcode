import java.util.*;
class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        String pat = "";
        for (char c : pattern.toCharArray()) {
            if (map.containsKey(c)) {
                pat += map.get(c);
            }
            else {
                index++;
                map.put(c, index);
                pat += index;
            }
        }
        
        String[] arr = s.split(" ");
        Map<String, Integer> m = new HashMap<>();
        index = 0;
        String s2 = "";
        
        for (String str : arr) {
            if (m.containsKey(str)) {
                s2 += m.get(str);
            }
            else {
                index++;
                m.put(str, index);
                s2 += index;
            }
        }
        
        
        return s2.equals(pat);
    }
}
