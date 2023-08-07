import org.junit.jupiter.api.Test;

public class MinPathSum {
    @Test
    public void testMinPathSum(){
        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(this.minPathSum(grid));

    }

    private int minPathSum(int[][] grid){
        int[][] history = new int[grid.length][grid[grid.length - 1].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0){
                    history[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0){
                    history[i][j] = grid[i][j] + history[i][j - 1];
                    continue;
                }
                if (j == 0){
                    history[i][j] = grid[i][j] + history[i - 1][j];
                    continue;
                }
                history[i][j] = grid[i][j] + Math.min(history[i][j - 1], history[i - 1][j]);
            }
        }
        return history[grid.length - 1][grid[grid.length - 1].length - 1];
    }

    private int minPathSumRecursion(int[][] grid){
        return searchMinPath(grid,0,0);
    }

    private int searchMinPath(int[][] grid,int m,int n){
        if (grid.length == m + 1 && grid[m].length == n + 1){
            return grid[m][n];
        }
        if (grid.length == m + 1){
            return grid[m][n] + searchMinPath(grid,m,n + 1);
        }
        if (grid[m].length == n + 1){
            return grid[m][n] + searchMinPath(grid,m + 1,n);
        }
        return Math.min(grid[m][n] + searchMinPath(grid,m + 1,n),
                grid[m][n] + searchMinPath(grid,m,n + 1));
    }
}
