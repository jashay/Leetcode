import java.util.*;
class ProductOfNumbers {

    List<Integer> list;
    int prev=1;
    public ProductOfNumbers() {
        list = new ArrayList<>();   
        list.add(1);
    }
    
    public void add(int num) {
        if (list.isEmpty() && num > 0) {
            list.add(num);
        }
        else if (num == 0) {
            list = new ArrayList<>();
            list.add(1);
            prev=1;
        }
        else {
            prev *= num;
            list.add(prev);
        }
    }
    
    public int getProduct(int k) {
        if (list.size() > k)
            return prev / list.get(list.size()-1-k);
        else return 0;
    }
}