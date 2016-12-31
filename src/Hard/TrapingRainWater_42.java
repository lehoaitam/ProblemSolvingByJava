package Hard;

/**
 * Created by lehoaitam on 11/2/16.
 */
public class TrapingRainWater_42 {
    public static void main(String[] args){
        int a[] = {3,0,2,0,4,0,6,0,2,0,5};
        System.out.println(new TrapingRainWater_42().trap(a));
    }
    public static int trap(int[] A) {
        int i = 0, j = A.length - 1, result = 0, plank = 0;
        while(i <= j){
            plank = plank < Math.min(A[i], A[j]) ? Math.min(A[i], A[j]) : plank;
            result = A[i] >= A[j] ? result + (plank - A[j--]) : result + (plank - A[i++]);
        }
        return result;
    }
}
