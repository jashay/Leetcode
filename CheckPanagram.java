public class CheckPanagram {
  public boolean checkIfPangram(String sentence) {
    int[] array = new int[26];
    
    for (char c : sentence.toCharArray()) {
        array[c-'a']++;
    }
    
    for (int x : array) {
        if (x <1) return false;
    }
    return true;
  }
}
