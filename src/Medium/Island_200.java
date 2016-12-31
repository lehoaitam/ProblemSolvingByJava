package Medium;

/**
 * Created by lehoaitam on 10/25/16.
 */
public class Island_200 {
    static int[][] steps = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int result = 0;
        int m = grid[0].length;
        boolean[][] cache = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(cache[i][j] == false && grid[i][j] == '1'){
                    result++;
                    dfs(i, j, n, m, grid, cache);
                }
            }
        }
        return result;
    }
    public void dfs(int i, int j,int n, int m, char[][] grid, boolean[][] cache){
        if(cache[i][j] == true || grid[i][j] == '0') return ;
        cache[i][j] = true;
        for(int k = 0; k < steps.length; k++){
            int x = i + steps[k][0];
            int y = j + steps[k][1];
            if(x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == '0') continue;
            dfs(x, y, n, m, grid, cache);
        }
    }
}
