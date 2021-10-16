public class STOI {
  public int myAtoi(String s) {
        
    int i=0;
    while (i < s.length() && s.charAt(i) == ' ') i++;
    int sign = 1;
    if (i >= s.length()) return 0;
    if (s.charAt(i) == '+') {
        i++;
    }
    else if (s.charAt(i) == '-') {
        sign = -1;
        i++;
    }
    if (i >= s.length()) return 0;
    StringBuilder sb = new StringBuilder();
    int flag = 0;
    while (i< s.length() && Character.isDigit(s.charAt(i))) {
        if (s.charAt(i) != '0') flag = 1;
        else if (s.charAt(i) == '0' && flag == 0) {
            i++;
            continue;
        }
        sb.append(s.charAt(i++));
    }
    
    if (sb.length() == 0) return 0;
    
    int ans;
    
    if (sb.length() > String.valueOf(Integer.MAX_VALUE).length()) {
        ans = Integer.MAX_VALUE;
        if (sign == -1) return -1 * ans -1;
        else return ans;
    }
    
    long t = Long.parseLong(sb.toString());
    
    if (t > (long) Integer.MAX_VALUE) {
        ans = Integer.MAX_VALUE;
        if (sign == -1) return -1 * ans -1;
    }
    else ans = Integer.parseInt(sb.toString());
    
    return sign*ans;
}
}
