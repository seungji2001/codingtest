package com.example.codingtest.dynamicprogramming;

public class Programmers {
    public static void main(String[] args) {
        int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        int a = dfs(0, 0, triangle, dp);
        System.out.println(a);
    }
    public int solution(int[][] triangle) {
        //[i][j]에서 [i][j] or [i][j+1] 중 작은것 택한다
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        int a = dfs(0, 0, triangle, dp);
        return a;
    }
    public static int dfs(int i, int j, int[][] t, int[][] dp){
        if(i == t.length - 1)
            return t[i][j];

        if(dp[i][j] != 0)
            return dp[i][j];


        int a = dfs(i+1, j, t, dp);
        int b = dfs(i+1, j+1, t, dp);

        int max = Math.max(a, b);
        dp[i][j] = max + t[i][j];
        // dp[i][j] = max + t[i][j];

        return dp[i][j];
    }
}
