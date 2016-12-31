package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lehoaitam on 10/25/16.
 */
public class FrogJump_403 {
    public static void main(String[] args){
        int a[] = {0,2};
        System.out.println(canCross(a));
    }
    public static boolean canCross(int[] stones) {
        if(stones.length < 2)
            return true;
        //build hashmap for list of stones
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int stone : stones){
            map.put(stone,new HashSet<Integer>());
        }
        //greedy approach
        int max = 0;
        HashSet<Integer> setTemp = new HashSet<Integer>();
        setTemp.add(0);
        map.put(0, setTemp);
        for(int i = 0; i < stones.length; i++){
            //get number of step to current stone
            Set<Integer> steps = map.get(stones[i]);
            //can skip remain stone if frog can jump to last stone
            if(max >= stones[stones.length-1]) return true;
            //update max step for next stones
            for(int step : steps){
                for(int temp = -1; temp <= 1; temp++){
                    int nextStep = step + temp;
                    if(nextStep <= 0) continue;
                        if(stones[i] + nextStep == stones[stones.length - 1]) return true;
                        if(map.containsKey(stones[i] + nextStep)){
                            Set set = map.get(stones[i] + nextStep);
                            if(!set.contains(step)) set.add(nextStep);
                        }
                }

            }
        }
        return false;
    }
}
