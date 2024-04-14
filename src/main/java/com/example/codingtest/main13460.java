package com.example.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class main13460 {
    public static void dontknow () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        String[][] box= new String[m][n];
        int[][] b = new int[m][n];
        int[][] r = new int[m][n];

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                String s = sc.next();
                if(s.equals("R")){
                    r[i][j] = 1;
                }
                if(s.equals("B")){
                    b[i][j] = 1;
                }
                box[i][j] = s;
            }
        }

        while(true){

        }
    }
}
