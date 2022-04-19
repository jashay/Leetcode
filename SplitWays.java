public class SplitWays {
    public int numWays(String s) {
        long n = s.length(), count = 0;
        if (n < 3) return 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == 'a') count++;
        if (count % 3 != 0) return 0;
        if (count == 0) return (int) ((n - 1) * (n - 2) / 2); 
        long first = 0, second = 0, avg = count / 3, prefixA = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') prefixA++;
            else {
                if (prefixA == avg) first++; 
                else if (prefixA == avg * 2) second++; 
            }
        }
        return (int) (++first * ++second); 
    }

    public static void main(String[] args) {
        SplitWays o  = new SplitWays();

        System.out.println(o.numWays("babaa"));
        System.out.println(o.numWays("ababa"));
        System.out.println(o.numWays("aba"));
        System.out.println(o.numWays("bbbbb"));


    }
}
