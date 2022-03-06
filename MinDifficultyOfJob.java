public class MinDifficultyOfJob {
    public int dfs(int[] K, int d, int pos, int[][] cache) {
        if (d == 0) {
            int max = K[pos];
            for (int i=pos; i<K.length; i++) max = Math.max(max, K[i]);
            return max;
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        int day = cache.length - d;
        
        if (cache[day][pos] != -1) return cache[day][pos];
        
        for (int i=pos; i<K.length - d; i++) {
            max = Math.max(max, K[i]);
            min = Math.min(min, max + dfs(K, d-1, i+1, cache));
        }
        cache[day][pos] = min;
        return min;
        
    }
   
    
    public int minDifficulty(int[] K, int d) {
        if (K.length < d) return -1;
        
        int[][] cache = new int[d-1][K.length];
        
        for (int i=0; i<d-1; i++) {
            for (int j=0; j<K.length; j++) {
                cache[i][j] = -1;
            }
        }
        
        return dfs(K, d-1, 0, cache);
    }
}
