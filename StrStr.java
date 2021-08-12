public class StrStr {
  public int strStr(String haystack, String needle) {
    int needleLen = needle.length();
    int hayLen = haystack.length();
    
    if (needleLen == 0) return 0;
    
    if (needleLen == hayLen) {
        if (haystack.equals(needle)) return 0;
    }
    
    for (int i=0; i<=hayLen-needleLen; i++) {
        if (haystack.substring(i, i+needleLen).equals(needle)) {
            return i;
        }
    }
    
    return -1;
  }
}
