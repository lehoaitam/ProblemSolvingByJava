package Hard;

/**
 * Created by lehoaitam on 10/29/16.
 */
public class LongestInscrease_329 {
    public static void main(String[] args){
        LongestInscrease_329 obj = new LongestInscrease_329();
        int[][] a = {{3,4,5},{3,2,6},{2,1,0}};
        System.out.println(obj.longestIncreasingPath(a));
    }
    int[][] di = {{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] mem = new int[n][m];
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mem[i][j] == 0)
                    dfs(matrix, mem, i, j, n, m);
                max = Math.max(max, mem[i][j]);
            }
        }
        return max;
    }
    public int dfs(int[][] matrix, int[][] mem, int i, int j, int n, int m){
        int max = 0;
        for(int k = 0; k < di.length; k++){
            int x = i + di[k][0];
            int y = j + di[k][1];
            if(x < 0 || x >= n || y < 0 || y >= m || matrix[x][y] <= matrix[i][j]) continue;
            if(mem[x][y] != 0) max = Math.max(max, mem[x][y]);
            else {
                max = Math.max(max, dfs(matrix, mem, x, y, n, m));
            }
        }
        mem[i][j] = 1 + max;
        return mem[i][j];
    }
}
