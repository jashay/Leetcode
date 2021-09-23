public class ReverseWordsInString2 {
  public void reverseArray(char[] s, int start, int end) {
    
    while (start < end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        start++;
        end--;
    }
}

  public void reverseWords(char[] s) {
      int start = 0, end = s.length-1;
      reverseArray(s, start, end);
      start = 0; 
      for (end = 0; end<s.length; end++) {
          if (s[end] == ' ') {
              reverseArray(s, start, end-1);
              start = end+1;
          }
          if (end == s.length-1) {
              reverseArray(s, start, end);
              break;
          }
      }
  }
}
