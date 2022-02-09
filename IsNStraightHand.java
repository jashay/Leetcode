import java.util.*;
public class IsNStraightHand {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        
        Arrays.sort(hand);
        
        for (int x : hand) {
            if (map.get(x) > 0) {
                for (int i=0; i<groupSize; i++) {
                    if (map.containsKey(i + x) && map.get(i+x) > 0) {
                        map.put(i+x, map.get(i+x)-1);
                    }
                    else {
                        return false;
                    }
                }
            }
            
        }
        
        return true;
    }
}
