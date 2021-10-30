import java.util.*;
public class NestedIterator {

  class NestedInteger {
    boolean isInteger() {
      return false;
    }

    int getInteger() {
      return 0;
    }

    List<NestedInteger> getList() {
      return null;
    }
  }

  List<Integer> list;
  int index = 0;
  public NestedIterator(List<NestedInteger> nestedList) {
      list = new ArrayList();
      
      flatten(nestedList);
  }
  
  public void flatten(List<NestedInteger> nestedList) {
      for (NestedInteger curr : nestedList) {
          if (curr.isInteger()) {
              list.add(curr.getInteger());
          }
          else {
              flatten(curr.getList());
          }
      }
      return;
  }

  public Integer next() {
      return list.get(index++);
  }

  public boolean hasNext() {
      return index < list.size();
  }
}

