public class PalindromePermutation {
  public boolean canPermutePalindrome(String s) {
    int oddFlag = 0;
    int[] freq = new int[26];
    
    for (char c : s.toCharArray()) {
        freq[c-'a']++;
    }
    
    for (int x : freq) {
        if (x % 2 != 0) {
            if (oddFlag == 1) return false;
            else oddFlag = 1;
        }
    }
    return true;
  }
}
