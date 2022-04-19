import java.util.*;
public class LargestIntAfterSwapWithSameParity {
  public int largestInteger(int num) {
    List<Integer> odd = new ArrayList<>();
    List<Integer> even = new ArrayList<>();
    String str = String.valueOf(num);
    for (int i=0; i< str.length(); i++) {
        int val = Character.getNumericValue(str.charAt(i));
        if (val%2 == 0) even.add(val);
        else odd.add(val);
    }
    
    Collections.sort(odd, (a,b) -> b - a);
    Collections.sort(even, (a,b) -> b - a);
    
    String ans = "";
    int ep = 0, op = 0;
    for (int i=0; i<str.length(); i++) {
        int val = Character.getNumericValue(str.charAt(i));
        if (val%2 == 0) ans += even.get(ep++);
        else ans += odd.get(op++);
    }
    
    return Integer.parseInt(ans);
}
}
