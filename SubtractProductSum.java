class SubtractProductSum {
    public int subtractProductAndSum(int n) {
        int sum = 0, prod = 1;
        
        while (n > 0) {
            int t= n%10;
            prod *= t;
            sum += t;
            n /= 10;
        }
        
        return prod-sum;
    }
}
