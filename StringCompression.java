public class StringCompression {
  public int compress(char[] chars) {
    StringBuilder sb = new StringBuilder();
    char prev = chars[0];
    sb.append(prev);
    int index = 0;
    for (int i=1; i<chars.length; i++) {
        if (chars[i] != prev) {
            if (i-index != 1) sb.append(i - index);
            sb.append(chars[i]);
            prev = chars[i];
            index =i;
        }
        else if (i==chars.length-1) {
            sb.append(i-index+1);
        }
    }
    
    for (int i=0; i<sb.length(); i++) {
        chars[i] = sb.charAt(i);
    }
    
    return sb.length();
  }
}
