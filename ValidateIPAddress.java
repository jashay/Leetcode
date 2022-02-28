import java.util.*;
public class ValidateIPAddress {
  public String validIPAddress(String IP) {
    String[] arr = IP.split("\\.", 4);
    if (arr.length == 4) {
        for (String s : arr) {
            if (s.length() > 3 || s.length() <1) return "Neither";
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) return "Neither";
            }
            if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0) return "Neither";
            if (s.length() > 1) {
                if (s.charAt(0) == '0') return "Neither";
            }
        }
        return "IPv4";
    }
    
    String[] arr2 = IP.split(":", 8);
    Set<Character> set= new HashSet<>();
    set.add('a');
    set.add('b');
    set.add('c');
    set.add('d');
    set.add('e');
    set.add('f');

    if (arr2.length == 8) {
        for (String s : arr2) {
            if (s.length() <1 || s.length() > 4) return "Neither";
            
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c) && !set.contains(Character.toLowerCase(c))) return "Neither";
            }
            
        }
        return "IPv6";
    }
    return "Neither";
}
}
