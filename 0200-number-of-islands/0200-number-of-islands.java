class Solution {
    /**
    섬의 개수를 반환
    DFS로 재귀를 돌며, 동서남북으로 다 탐색이 끝났으면, island의 수를 하나씩 증가하는 방식  
    */

    public void dfs(int i, int j, char[][] grid){
        //종료 조건 -> 경계를 벗어나거나, 탐색중인 곳의 0이라서 더 이상 탐색 불가능할때
        if(i<0 || i >= grid.length || j <0 || j>=grid[0].length || grid[i][j] == '0') return;

        //발견 한 곳은 0으로 변환해서 무한 반복되지 않게
        grid[i][j] = '0';
        //동쪽 이동
        dfs(i, j+1, grid);
        
        //서쪽 이동
        dfs(i, j-1, grid);

        //남쪽 이동
        dfs(i+1, j, grid);

        //북쪽 이동
        dfs(i-1, j, grid);
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){

                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
}