import java.util.*;
public class BullsAndCows {
  public String getHint(String secret, String guess) {
    int bulls = 0, cows = 0;
    StringBuilder potentialCows = new StringBuilder();
    Map<Character, Integer> map = new HashMap<>();
    
    for (int i=0 ;i<secret.length(); i++) {
        if (secret.charAt(i) == guess.charAt(i)) bulls++;
        else {
            map.put(guess.charAt(i), map.getOrDefault(guess.charAt(i), 0)+1);
            potentialCows.append(secret.charAt(i));
        }
    }
    
    for (char c : potentialCows.toString().toCharArray()) {
        if (map.containsKey(c) && map.get(c) >0) {
            cows++;
            map.put(c, map.get(c)-1);
        }
    }
    
    return bulls+"A"+cows+"B";
  }
}
