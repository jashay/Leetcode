import java.util.*;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        
        for (int point : cardPoints) {
            total += point;
        }
        
        if (cardPoints.length - k == 0) return total;
        
        int end = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        int currTotal =0;
        
        for (; end < cardPoints.length; end++) {
            if (end - start == cardPoints.length - 1 - k) {
                currTotal += cardPoints[end];
                max = Math.max(max, total - currTotal);
                currTotal -= cardPoints[start];
                start++;
                continue;
            }
            
            currTotal += cardPoints[end];
        }
        
        return max;
    }
}

// Sliding window of size cardPoints.length - k
// Highest difference from total is our answer

