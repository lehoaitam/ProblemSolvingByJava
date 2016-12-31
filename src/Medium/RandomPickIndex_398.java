package Medium;

import java.util.*;

/**
 * Created by lehoaitam on 10/30/16.
 */
public class RandomPickIndex_398 {
    Map<Integer, List> map;
    public static void main(String[] args){
        int[] nums = new int[] {1,2,3,3,3};
        RandomPickIndex_398 solution = new RandomPickIndex_398(nums);
        System.out.println(solution.pick(1));
    }
    public RandomPickIndex_398(int[] nums) {
        map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            List l = map.get(nums[i]);
            if(l == null) l = new ArrayList<Integer>();
            l.add(i);
            map.put(nums[i], l);
        };
    }

    public int pick(int target) {
        List l = map.get(target);
        int randomOIndexOfList = new Random().nextInt(l.size());
        return (int)l.get(randomOIndexOfList);
    }
}
