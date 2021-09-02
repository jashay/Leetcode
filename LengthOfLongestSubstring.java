import java.util.*;
public class LengthOfLongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() <= 1) return s.length();
    int i=0;
    Set<Character> set = new HashSet<>();
    int j=1;
    set.add(s.charAt(i));
    int max = 0;
    while (j<s.length()) {
        if (set.contains(s.charAt(j))) {
            set.remove(s.charAt(i++));
        }
        else {
            set.add(s.charAt(j));
            max = Math.max(max, set.size());
            j++;
        }
    }
    return max;
}
}
