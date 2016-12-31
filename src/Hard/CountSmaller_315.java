package Hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Created by lehoaitam on 10/28/16.
 */
public class CountSmaller_315 {
    public static void main(String[] agrs){
        CountSmaller_315 obj = new CountSmaller_315();
        int []a = {-8,-10,12,51,7,15,4,8};
        List l = obj.countSmaller(a);
        System.out.println(l);
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int[] sortedArray = nums.clone();
        Arrays.sort(sortedArray);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 1; i <= sortedArray.length; i++)map.put(sortedArray[i-1],i);
        int[] T = new int[sortedArray.length + 1];
        for(int i = nums.length - 1; i >= 0; i--){
            int k = map.get(nums[i]);
            result.add(0, get(T, k - 1));
            update(T, k , 1);
        }
        return result;
    }
    private void update(int[] T, int index, int value){
        for(int i = index; i < T.length; i+= (i & (-i))) T[i] += value;
    }
    private int get(int[] T, int index){
        int result = 0;
        for(int i = index; i > 0; i -= (i & (-i))) result += T[i];
        return result;
    }

}
