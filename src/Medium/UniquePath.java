package Medium;

/**
 * Created by lehoaitam on 11/2/16.
 */
public class UniquePath {
    public static void main(String[] args){
        System.out.println(new UniquePath().uniquePaths(5, 4));
    }
    public static int uniquePaths(int m, int n) {

        long result = 1;
        int temp1, temp2, temp;
        for(int i=1;i<Math.min(m,n);i++) {
            temp1  = m + n - 2 - i;
            temp2 = i + 1;
            temp = temp1 / temp2;
            result = result*(m+n-1-i)/(i);
            //result = result * temp;
        }
        return (int)result;

    }
}
