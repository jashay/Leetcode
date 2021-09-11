import java.util.*;
public class CompareStringByFreqOfSmallestChar {
  public int[] numSmallerByFrequency(String[] queries, String[] words) {
    List<Integer> count = new ArrayList<>();
    
    for (String word : words) {
        char[] array = word.toCharArray();
        Arrays.sort(array);
        char c = array[0];
        int freq = 1;
        for (int i=1; i<array.length;i++) {
            if (c != array[i]) break;
            freq++;
        }
        count.add(freq);
    }
    
    int[] ans = new int[queries.length];
    
    for (int a=0; a<queries.length; a++) {
        char[] array = queries[a].toCharArray();
        Arrays.sort(array);
        char c = array[0];
        int freq = 1;
        for (int i=1; i<array.length;i++) {
            if (c != array[i]) break;
            freq++;
        }
        int counter=0;
        for (int x : count) {
            if (x> freq) {
                counter++;
            }
        }
        ans[a] = counter;
    }
    
    
    return ans;
}
}
