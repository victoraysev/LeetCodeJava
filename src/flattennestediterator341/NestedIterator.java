package flattennestediterator341;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public abstract class NestedIterator implements Iterator<Integer> {
    int index;
    Deque<Integer> deque = new ArrayDeque<>();
    List<NestedInteger> nestedList;

    public List<Integer> unflatten(NestedInteger nestedInteger) {
//        return nestedInteger.getList().stream()
//                .flatMap(nestedInteger -> nestedInteger.isInteger() ?
//                        List.of(nestedInteger.getInteger()).stream() :
//                        unflatten(nestedInteger.getList()).stream())
//                .collect(Collectors.toList());
//    }
//    public NestedIterator(List<NestedInteger> nestedList) {
//
//        index = 0;
//        this.nestedList = nestedList;
//        this.deque = new ArrayDeque<>();
//    }
//
//    @Override
//    public Integer next() {
//        if(!deque.isEmpty()){
//            return deque.pop();
//        }
//        else if(nestedList.get(index).isInteger()){
//            index++;
//            return nestedList.get(index - 1).getInteger();
//        }
//        else{
//            index++;
//            var obj = unflatten(nestedList.get(index));
//        }
//    }
//
//    @Override
//    public boolean hasNext() {
//        return index < nestedList.size();
//    }
        return null;
    }
}
