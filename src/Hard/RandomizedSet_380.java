package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by lehoaitam on 10/22/16.
 */

public class RandomizedSet_380 {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet_380() {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int pos = map.get(val);
        //replace by last item
        int listSize = list.size();
        if(pos < listSize){
            //replace by lastitem
            int lastItem = list.get(listSize - 1);
            list.set(pos,lastItem);
            map.put(lastItem,pos);
        }
        //remove last item
        list.remove(list.size()-1);
        //remove from map
        map.remove(val);
        //update new position for last item;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}