public class GuessNumberHigherOrLower {

  //black box
  public int guess(int g) {
    return 0;
  }
  public int guessNumber(int n) {
        
    int start = 1;
    int end = n;
    
    while (start<=end) {
        int g = start +(end-start)/2;
        int a = guess(g);
        if (a == 0) {
            return g;
        }
        else if (a == 1) {
            start = g+1;
        }
        else {
            end = g-1;
        }
    }
    return -1;
}
}
