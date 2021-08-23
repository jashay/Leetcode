public class MergeAlternatively {
  public String mergeAlternately(String word1, String word2) {
    StringBuilder sb=new StringBuilder();
    int len = Math.min(word1.length(), word2.length());
    int x = 0, y=0;
    for (int i=0; i<len*2; i++) {
        if (i%2 == 0) {
            sb.append(word1.charAt(x));
            x++;
        }
        else {
            sb.append(word2.charAt(y));
            y++;
        }
    }
    
    while (x < word1.length()) {
        sb.append(word1.charAt(x));
        x++;
    }
    while (y < word2.length()) {
        sb.append(word2.charAt(y));
        y++;
    }
    
    return sb.toString();
  }
}
