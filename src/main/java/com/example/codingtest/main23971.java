package com.example.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main23971 {
    static int n;
    static int m;
//    static int[][] visited;
//    static int maxCnt;
    static int h;
    static int w;

    public static void memoryout(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        h = Integer.parseInt(st.nextToken());
        w= Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken()); //세로
        m = Integer.parseInt(st.nextToken()); //가로

        int result = (h*w)/((m+1)*(n+1) - 1);
        System.out.println(result);
//        visited = new int[h][w];

//        maxCnt = 1;
//
//       bfs(0, 0);
//        System.out.println(maxCnt);
    }

    public static void bfs(int startN, int startM){
//        visited[startN][startM] = 1;

        int nx = startN + n + 1;
        int ny = startM + m + 1;
        if(nx<h){
//            if(visited[nx][startM] != 1){
//                maxCnt++;
                bfs(nx, startM);
//            }
        }
        if(ny < w){
//            if(visited[startN][ny] != 1){
//                maxCnt++;
                bfs(startN, ny);
//            }
        }
    }
}
