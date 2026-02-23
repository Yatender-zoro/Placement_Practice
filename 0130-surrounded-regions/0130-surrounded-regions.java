class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        // top row
        for(int i=0;i<n;i++){
            if(board[0][i]=='O')
                DFS(board,vis,0,i);
        }

        // bottom row
        for(int i=0;i<n;i++){
            if(board[m-1][i]=='O')
                DFS(board,vis,m-1,i);
        }

        // left col

        for(int i=0;i<m;i++){
            if(board[i][0]=='O')
                DFS(board,vis,i,0);
        }

        // right col

        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O')
                DFS(board,vis,i,n-1);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && vis[i][j]==false){
                    board[i][j] = 'X';
                }
            }
        }
    }

    void DFS(char[][] board,boolean[][] vis,int i,int j){
        
        if(i<0 || j<0 || i>=vis.length || j>=vis[0].length || board[i][j]=='X' || vis[i][j] == true) return;
        vis[i][j] = true;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        for(int l=0;l<4;l++){
            DFS(board,vis,i+dx[l],j+dy[l]);
        }
    }
}