import java.util.*;
public class SecondHighest {
  public int secondHighest(String s) {
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (char c : s.toCharArray()) {
        if (Character.isDigit(c)) {
            int num = Integer.parseInt(String.valueOf(c));
            if (!set.contains(num)) {
                set.add(num);
                if (list.size() <2) {
                 list.add(num);
                }
                else {
                    if (num > list.get(0)) {
                        list.remove(0);
                        list.add(num);
                    }
                }
                Collections.sort(list);
            }
        }
    }
    
    if (list.size() == 2) return list.get(0);
    else return -1;
}
}
