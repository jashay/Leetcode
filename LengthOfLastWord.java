import java.util.*;
public class LengthOfLastWord {
  public int lengthOfLastWord(String s) {
    String[] array = s.split(" ");
    List<String> ans = new ArrayList<>();
    
    for (String word : array) {
        if (!word.equals(" ")) {
            ans.add(word);
        }
    }
    
    String lastWord = ans.get(ans.size()-1);
    return lastWord.length();
}
}
