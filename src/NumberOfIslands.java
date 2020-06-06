public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length==0)
            return 0;

        int numIslands = 0;

        for(int i=0; i<grid.length; i++){
            System.out.println("i times "+ i +" Gird length "+ grid.length);
            for(int j=0; j<grid[i].length; j++){
                System.out.println("j times "+ j +" Gird of ith length "+ grid[i].length);
                if(grid[i][j]=='1'){
                    numIslands += dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    public static int dfs(char[][] grid, int i, int j){
        if(i < 0 || i > grid.length || j<0 || j>grid.length || grid[i][j]=='0')
            return 0;

        grid[i][j]='0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        return 1;
    }

    public static void main(String args[]){
        //char[][] inputStrings = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] inputStrings = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','0'}};
        int count= numIslands(inputStrings);
        System.out.println("Count of islands "+ count);
    }
}

