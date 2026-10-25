
class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++)
            {
                if (grid[i][j] == 0)
                {
                    if (dfs(grid, i, j, rows, cols)) 
                    {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, int r, int c,int rows, int cols) 
    {
        if (r < 0 || c < 0 || r >= rows || c >= cols)
        {
            return false;
        }

        if (grid[r][c] == 1) 
        {
            return true;
        }

        grid[r][c] = 1;

        boolean up = dfs(grid, r - 1, c, rows, cols);
        boolean down = dfs(grid, r + 1, c, rows, cols);
        boolean left = dfs(grid, r, c - 1, rows, cols);
        boolean right = dfs(grid, r, c + 1, rows, cols);

        return up && down && left && right;
    }
}
