public class ValidWordAbbreviation {
  public boolean validWordAbbreviation(String word, String abbr) {
    StringBuilder sb = new StringBuilder();
    int wordIndex = 0;
    for (int i=0; i<abbr.length(); i++) {
        char c = abbr.charAt(i);
        if (Character.isDigit(c)) {
            if (c == '0') return false;
            String num = ""+c;
            int x=i;
            while (x+1<abbr.length() && Character.isDigit(abbr.charAt(x+1))) {
                num+=abbr.charAt(++x);
            }
            
            int n = Integer.parseInt(num);
            if (wordIndex+n > word.length()) return false;
            String sub = word.substring(wordIndex, wordIndex+n);
            i=x;
            wordIndex += n;
            sb.append(sub);
        }
        else {
            wordIndex++;
            sb.append(c);
        }
        
    }
    
    if (sb.toString().equals(word)) return true;
    
    return false;
}
}
