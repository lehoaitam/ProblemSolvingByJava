package Medium;

/**
 * Created by lehoaitam on 10/21/16.
 */
public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = 0, total = 0, tank = 0;
        for(int i = 0; i < cost.length; i++){
            int diff = gas[i] - cost[i];
            tank += diff;
            total += diff;
            if(tank < 0){
                tank = 0;
                result++;
            }
        }
        return (total > 0) ? result : -1;
    }
}
