public class HappyNumber {
  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    while (true) {
        if (n==1) return true;

        if (set.contains(n)) {
            return false;
        }
        else {
            set.add(n);
        }
                    
        int sum = 0;
        
        while (n>0) {
            int t = n%10;
            sum += t*t;
            n /= 10;
        }
        
        n = sum;
    }
  }
}
