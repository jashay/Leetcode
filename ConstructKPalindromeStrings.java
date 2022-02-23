public class ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (k > n) return false;
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
        int oddCount = 0;
        for (int i=0; i<26; i++) {
            oddCount += count[i]%2 != 0 ? 1 : 0;
        }
        
        return oddCount <= k;
    }
}
