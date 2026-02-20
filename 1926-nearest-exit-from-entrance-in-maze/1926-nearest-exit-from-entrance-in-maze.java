class Solution {
    public int nearestExit(char[][] maze, int[] en) {

        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        q.add(new int[]{en[0],en[1],0});
        vis[en[0]][en[1]] = true;
       
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,-1,1};
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            int cr = curr[0];
            int cc = curr[1];
            int cd = curr[2];

            if(cr==0 || cr == m-1  || cc ==0 || cc == n-1){
                if(!(cr==en[0] && cc==en[1])) return cd;
            }

            

            for(int i=0;i<4;i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    if(!vis[nr][nc] && (maze[nr][nc] != '+')){
                        vis[nr][nc] = true;
                        q.add(new int[]{nr,nc,cd+1});
                    }
                }
            }
        }
        return -1;
    }
}