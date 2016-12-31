package Hard;

import java.util.*;

/**
 * Created by lehoaitam on 10/22/16.
 */
public class RandomizedSet_381 {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet_381() {
        map = new HashMap<Integer,Set<Integer>>();
        list = new ArrayList<Integer>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isContained = map.containsKey(val);
        Set<Integer> set = map.get(val);
        if(set == null) set = new HashSet<>();
        set.add(list.size());
        map.put(val,set);
        list.add(val);
        return !isContained;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        Set<Integer> set = map.get(val);
        //get first pos of val
        int pos = set.iterator().next();
        set.remove(pos);
        if(pos < list.size()-1){
            //replace by lastitem
            int lastItem = list.get(list.size()-1);
            list.set(pos,lastItem);
            //update pos of lastitem in map
            Set<Integer> lastItemPos = map.get(lastItem);
            lastItemPos.remove(list.size()-1);
            lastItemPos.add(pos);
        }
        list.remove(list.size()-1);

        if(set.isEmpty()) map.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
