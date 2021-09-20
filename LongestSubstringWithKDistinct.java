import java.util.*;
public class LongestSubstringWithKDistinct {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new HashMap();
    int right = 0, left =0, max = Integer.MIN_VALUE;
    
    if (k==0) return 0;
    
    for (right = 0; right<s.length(); right++) {
        while (map.size() >= k) {
            if (map.size() == k && map.containsKey(s.charAt(right))) break;
            map.put(s.charAt(left), map.get(s.charAt(left))-1);
            if (map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
            left++;
        }
        map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
        max = Math.max(max, right-left+1);
    }
    
    return max;
}
}
