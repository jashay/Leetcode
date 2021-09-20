public class PermutationInString {
  public boolean checkInclusion(String s1, String s2) {
    int len = s1.length();
    int end = 0, start = 0;
    int[] chars = new int[26];
    
    for (char c : s1.toCharArray()) {
        chars[c-'a']++;
    }
    int diff = len;
    char temp;
    for (end = 0; end<s2.length(); end++) {
        if (end-start >= len) {
            temp = s2.charAt(start);
            
            chars[temp-'a']++;
            
            if (chars[temp-'a'] > 0) {
                diff++;
            }
            start++;
        }
        
        temp = s2.charAt(end);
        chars[temp-'a']--;
        
        if (chars[temp-'a'] >= 0) {
            diff--;
        }
        
        if (diff == 0) return true;
    }
    
    return false;
  }
}
