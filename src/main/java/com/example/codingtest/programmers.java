package com.example.codingtest;

import java.util.Arrays;

public class programmers {
    public static int[] dx={-1, 0, 0, 1};
    public static int[] dy={0,-1,1,0};
    public static int[][] visited;
    int landXlength;
    int landYlength;

   public static void main(String[] args) {

       int[][] land = {
               {0, 0, 0, 1, 1, 1, 0, 0},
               {0, 0, 0, 0, 1, 1, 0, 0},
               {1, 1, 0, 0, 0, 1, 1, 0},
               {1, 1, 1, 0, 0, 0, 0, 0},
               {1, 1, 1, 0, 0, 0, 1, 1}
       };

       visited = new int[land.length][land[0].length];

       for(int i = 0; i< land.length; i++){
           for(int j = 0; j<land[0].length; j++){
               if(visited[i][j] == 1){
                   continue;
               }
               int result = bfs(i, j, land, 0);
               System.out.println(result);
           }
       }

       System.out.println(Arrays.deepToString(land));

    }

    public static int bfs(int i, int j, int[][] land, int cnt){
        if(visited[i][j] == 1)
            return 0;
        for(int k = 0; k<4; k++){
            int check_x = j + dx[k];
            int check_y = i + dy[k];

            if(check_x>=0 && check_x<land[0].length && check_y>=0 && check_y< land.length){
                visited[check_y][check_x] = 1;
                if(land[check_y][check_x] == 1){
                    cnt += bfs(check_y, check_x, land, cnt);
                }
            }
        }
        return cnt;
    }
}
