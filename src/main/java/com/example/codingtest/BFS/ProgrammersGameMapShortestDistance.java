package com.example.codingtest.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ProgrammersGameMapShortestDistance {

        static int xlen;
    static int ylen;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
//    static int[][] visited;
    static int min;

        public static void main(String[] args) {
            int[][] maps = new int[][]{
                    {1, 0, 1, 1, 1},
                    {1, 0, 1, 0, 1},
                    {1, 0, 1, 1, 1},
                    {1, 1, 1, 0, 0},
                    {0, 0, 0, 0, 1}
            };
            int answer = 0;
            xlen = maps[0].length;
            ylen = maps.length;
            int[][] visited = new int[ylen][xlen];
            int[][] memoization = new int[ylen][xlen];

            //queue사용
            Queue<int[]> q = new LinkedList<>();
            //방문 위치, 값
            q.add(new int[]{0, 0, 1});
            while (!q.isEmpty()){
                int[] c = q.poll();
                int row = c[0];
                int col = c[1];
                int val = c[2];

                visited[row][col] = 1;
                if(row == ylen-1 && col == xlen -1)
                    answer = val;
                for(int i = 0; i<4; i++) {
                    int xCheck = dx[i] + col;
                    int yCheck = dy[i] + row;
                    if (xCheck >= 0 && xCheck < xlen && yCheck >= 0 && yCheck < ylen
                    && visited[yCheck][xCheck] == 0
                    && maps[yCheck][xCheck] == 1
                    ) {
                        q.add(new int[]{yCheck, xCheck, val + 1});
                    }
                }
            }
            if(answer == 0)
                answer = -1;

            System.out.println(answer);

//            min = Integer.MAX_VALUE;

            //이동거리 담아야한다
//            bfs(0, 0,  maps, visited);
//            memoization(0, 0, maps, memoization);

//            answer = memoization[ylen-1][xlen-1];
//            System.out.println(visited);
        }

        public static void bfs(int x, int y, int[][] m, int[][] visited){
            if(visited[y][x] == 1)
                return;
//            if(y == ylen - 1 && x == xlen - 1) {
//                min = Math.min(min, sum);
//                return;
//            }
            visited[y][x] = 1;
            //상하좌우로 이동하며 최대거리가 가장 가까운곳이다
            for(int i = 0; i<4; i++){
                int xCheck = dx[i] + x;
                int yCheck = dy[i] + y;
                if(xCheck >= 0 && xCheck < xlen && yCheck >= 0 && yCheck < ylen && m[yCheck][xCheck] == 1){
                    if(visited[yCheck][xCheck] == 1){
                        continue;
                    }
                    else{
                        bfs(xCheck, yCheck, m, visited);
                        System.out.println(xCheck);
                    }
                }
            }
        }
        public static void memoization(int x, int y, int[][] m, int[][] memo){
            if(x == 0 && y == 0){
                memo[y][x] = m[y][x];
            }
            if(x+1 < xlen && y+1 < ylen && x>=0 && y>=0){
                if(m[y][x+1] == 1){
                    memo[y][x + 1] = memo[y][x] + m[y][x+1];
                    memoization(x+1, y, m, memo);
                }
                if(m[y+1][x] == 1){
                    memo[y+1][x] = memo[y][x] + m[y+1][x];
                    memoization(x, y+1, m, memo);
                }
                if(m[y-1][x] == 1){
                    memo[y-1][x] = memo[y][x] + m[y-1][x];
                    memoization(x, y-1, m, memo);
                }
                if(m[y][x-1] == 1){
                    memo[y][x - 1] = memo[y][x] + m[y][x-1];
                    memoization(x-1, y, m, memo);
                }
            }
        }
    }
