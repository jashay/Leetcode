import java.util.*;
public class ReplaceWords {
  public String replaceWords(List<String> dictionary, String sentence) {
    String[] array = sentence.split(" ");
    Set<String> set = new HashSet<>();
    
    for (String word : dictionary) {
        set.add(word);
    }
    
    for (int i=0; i<array.length; i++) {
        StringBuilder sb = new StringBuilder();
        String word = array[i];
        for (char c : word.toCharArray()) {
            sb.append(c);
            if (set.contains(sb.toString())) {
                array[i] = sb.toString();
                break;
            }
        }
    }
    
    StringBuilder ans = new StringBuilder();
    ans.append(array[0]);
    for (int i=1; i<array.length; i++) {
        String word = array[i];
        ans.append(" "+word);
    }
    
    return ans.toString();
}
}
