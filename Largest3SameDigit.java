import java.util.*;
public class Largest3SameDigit {
  public String largestGoodInteger(String num) {
    List<String> l = new ArrayList<>();
    for (int i=0; i<=num.length()-3; i++) {
        int p = Character.getNumericValue(num.charAt(i));
        boolean f = true;
        for (int j=i; j<=i+2; j++) {
            int curr = Character.getNumericValue(num.charAt(j));
            if (curr != p) {
                f=false;
                break;
            }
        }
        
        if (f) l.add(num.substring(i,i+3));
    }
    
    Collections.sort(l);
    
    return l.isEmpty() ? "" : l.get(l.size()-1);
  }
}
