import java.util.*;
public class TopKFrequentWords {
  class Pair {
    int count;
    String word;
    
    public Pair(String w, int c) {
        this.word = w;
        this.count = c;
    }
}

  public List<String> topKFrequent(String[] words, int k) {
    
    Queue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
        public int compare(Pair a, Pair b) {
            if (a.count == b.count) {
                return a.word.compareTo(b.word);
            }
            
            return b.count-a.count;
        }
    });
    Map<String, Integer> map = new HashMap<>();
    
    for (String word : words) {
        map.put(word, map.getOrDefault(word, 0)+1);
    }
    
    for (String key : map.keySet()) {
        int c = map.get(key);
        minHeap.offer(new Pair(key, c));
    }
    List<String> ans = new ArrayList<>();
    for (int i=0; i<k; i++) {
        Pair t = minHeap.poll();
        ans.add(t.word);
    }
    
    return ans;
  }
}
