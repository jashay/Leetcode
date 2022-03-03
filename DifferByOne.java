import java.util.*;
class DifferByOne {
  public boolean differByOne(String[] dict) {
    Set<String> set = new HashSet<>();
    
    for (String w : dict) {
        for (int i=0; i<w.length(); i++) {
            String sub = ((i==0) ? "*" : w.substring(0, i)) + "*"+w.substring(i+1, w.length());
            if (set.contains(sub)) return true;
            set.add(sub);
        }
    }
    
    return false;
}
}