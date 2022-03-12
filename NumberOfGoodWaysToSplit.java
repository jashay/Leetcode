import java.util.*;
public class NumberOfGoodWaysToSplit {
  public int numSplits(String s) {
        
    int[] leftFreq = new int[s.length()];
    int[] rightFreq = new int[s.length()];
    Set<Character> set = new HashSet<>();
    leftFreq[0] = 1;
    set.add(s.charAt(0));
    for (int i=1; i<s.length(); i++) {
        char c = s.charAt(i);
        if (set.contains(c)) {
            leftFreq[i] = leftFreq[i-1];
        }
        else {
            set.add(c);
            leftFreq[i] = leftFreq[i-1]+1;
        }
    }
    set = new HashSet<>();
    rightFreq[s.length()-1] = 0;
    for (int i=s.length()-2; i>=0; i--) {
        char c = s.charAt(i+1);
        if (set.contains(c)) {
            rightFreq[i] = rightFreq[i+1];
        }
        else {
            set.add(c);
            rightFreq[i] = rightFreq[i+1]+1;
        }
        
    }
    
    int ans = 0;
    
    for (int i=0; i<s.length(); i++) {
        if (leftFreq[i] == rightFreq[i]) ans++;
    }
    
    return ans;
}
}
