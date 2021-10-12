import java.util.*;
class FindAllAnagramsInString {
  public List<Integer> findAnagrams(String s, String p) {
    int n = s.length(), m = p.length();
    List<Integer> ans = new ArrayList();
    if (n<m) return ans;
    
    int[] pCount = new int[26];
    int[] sCount = new int[26];
    
    for (char c : p.toCharArray()) {
        pCount[c-'a']++;
    }
    
    for (int i=0; i<n; i++) {
        sCount[s.charAt(i)-'a']++;
        if (i>=m) sCount[(s.charAt(i-m))-'a']--;
        
        if (Arrays.equals(sCount, pCount)) ans.add(i-m+1);
    }
    return ans;
  }
}
