package Medium;

/**
 * Created by lehoaitam on 10/28/16.
 */
public class MaxArray_53 {
    public static void main(String[] args){
        int[] a = {-1};
        MaxArray_53 obj = new MaxArray_53();
        System.out.println(obj.maxArray(a));
    }
    private int maxArray(int[] nums){
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;
        for(int num : nums){
            localMax = Math.max(localMax + num, num );
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}
