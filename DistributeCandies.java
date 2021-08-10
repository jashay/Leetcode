import java.util.*;
public class DistributeCandies {
  public int distributeCandies(int[] candyType) {
    Set<Integer> set = new HashSet<>();
    
    for (int c : candyType) {
        if (!set.contains(c)) {
            set.add(c);
        }
    }
    
    if (set.size() > candyType.length/2) {
        return candyType.length/2;
    }
    else {
        return set.size();
    }
  }
}