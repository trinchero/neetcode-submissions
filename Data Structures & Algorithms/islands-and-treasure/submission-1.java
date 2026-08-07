class Solution {
    public void islandsAndTreasure(int[][] grid) {
        /*
        anziche usare un approccio ricorsivo con dfs uso un approccio bfs
        questo perche il goal non e cercare numero isole, ma trovare per ciascuna isola distanza dal piu vicino tesoro.
        In questo caso significa storare in una coda per esplorare per livelli
        */
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            for(int i=0; i<directions.length; i++){
                int newRow = row+directions[i][0];
                int newCol = col+directions[i][1];
                if(newRow<0 || newRow>=grid.length || newCol<0 || newCol>=grid[0].length){
                    continue;
                }
                if(grid[newRow][newCol]!=Integer.MAX_VALUE){continue;}
                grid[newRow][newCol]=grid[row][col]+1;
                queue.offer(new int[]{newRow,newCol});
            }
        }
    }
}
