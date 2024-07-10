/*
给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。

网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，
但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。

岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
*/

const int dx[4] = {0, 1, 0, -1};        // 岛屿坐标的增量
const int dy[4] = {1, 0, -1, 0};

int islandPerimeter(int** grid, int gridSize, int* gridColSize) {
    int n = gridSize;       // 格子的行数
    int m = gridColSize[0];    // 格子的列数
    int ans = 0;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            
            if(grid[i][j]){
                int count = 0;
                for(int k = 0; k < 4; k++){
                    int tx = i + dx[k];
                    int ty = j + dy[k];
                    if(tx < 0 || tx >= n || ty < 0 || ty >= m || !grid[tx][ty]){
                        count++;
                    }
                }
                ans += count;
            }
            
        }
    }

    return ans;
}