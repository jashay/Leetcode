public class ShortestToChar {
  public int[] shortestToChar(String s, char c) {
    int[] ans = new int[s.length()];
    for (int i=0; i<s.length(); i++) {
        char x = s.charAt(i);
        int rightDist=0, leftDist=0, lflag=0, rflag=0, leftCounter=0, rightCounter=0;
        int currIndex = i;
        while (currIndex < s.length()) {
            if (s.charAt(currIndex) == c) {
                rflag = 1;
                break;
            }
            currIndex +=1;
            rightCounter++;
        }
        currIndex = i;
        while (currIndex >= 0) {
            if (s.charAt(currIndex) == c) {
                lflag = 1;
                break;
            }
            currIndex -=1;
            leftCounter++;
        }
        if (lflag == 0) leftCounter = Integer.MAX_VALUE;
        if (rflag == 0) rightCounter = Integer.MAX_VALUE;
        ans[i] = Math.min(leftCounter, rightCounter);
    }
    return ans;
}
}
