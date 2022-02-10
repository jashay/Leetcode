import java.util.*;
public class ValidPalindrome3 {
  Map<String, Boolean> dp = new HashMap<>();
    public boolean isPalindrome (String s, int end, int start) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                dp.put(start+","+end+",0", false);
                return false;
            }
            start++;
            end--;
        }
        dp.put(start+","+end+",0", true);
        return true;
    }
    
        
    public boolean validate(String s, int start, int end, int k) {
        if (dp.containsKey(start+","+end+","+k)) return dp.get(start+","+end+","+k);
        if (k==0) {
            return isPalindrome(s, end, start);
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                boolean res = validate(s, start+1, end, k-1) ||
                validate(s, start, end-1, k-1);
                dp.put(start+","+end+","+k, res);
                return res;
            }
            start++;
            end--;
        }
       
        dp.put(start+","+end+","+k, true);
        return true;
    }
    
    public boolean isValidPalindrome(String s, int k) {
        return validate(s, 0, s.length()-1, k);
    }
}
