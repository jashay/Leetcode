import java.util.*;
public class LongestWord {
  public String longestWord(String[] words) {
    Set<String> set = new HashSet<>();
    String maxWord = "";
    Arrays.sort(words);
    
    for (String word : words) {
        if (word.length() == 1 || set.contains(word.substring(0, word.length()-1))) {
            set.add(word);
            maxWord = maxWord.length() < word.length() ? word : maxWord;
        }
    }
    
    
    return maxWord;
}
}
