package com.example.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class main1012 {
    public static int[][] box;
    public static int[][] visited;
    public static int[] nx = {0,0,-1,1};
    public static int[] ny = {-1,1,0,0};
    public static int m;
    public static int n;
    public static int cnt = 1;
    public static void main1012() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        List<Integer> result;
        for(int a= 0; a<t; a++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            m = Integer.parseInt(str.nextToken());
            n = Integer.parseInt(str.nextToken());
            int k = Integer.parseInt(str.nextToken());
            box = new int[m][n];
            visited = new int[m][n];

            for(int i = 0; i<k; i++){
                str = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(str.nextToken());
                int y = Integer.parseInt(str.nextToken());
                box[x][y] = 1;
            }


            cnt = 0;
            result = new LinkedList<>();
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    if(visited[i][j] != 1 && box[i][j] == 1){
                        dfs(i, j); //탐색하는 번호
                        result.add(cnt);
                        cnt = 0;
                    }
                }
            }

            System.out.println(result.size());
        }
    }

    public static void dfs(int x, int y){
        visited[x][y] = 1;

        for(int i = 0; i<4; i++){
            int newX = x + nx[i];
            int newY = y + ny[i];
            if(newX >= 0 && newX < m && newY>=0 && newY<n && box[newX][newY] == 1 && visited[newX][newY] != 1){
                dfs(newX, newY);
                cnt++;
            }
        }


        cnt++;
    }
}
