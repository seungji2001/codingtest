package com.example.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon {
    public static Scanner sc = new Scanner(System.in);
    static int a = 0;
    public static void main2667() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        visited = new int[n][n];
        for(int i = 0; i<n; i++){
            String st = br.readLine();
            for(int j = 0; j<n; j++){
                arr[i][j] = st.charAt(j) - '0';
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                bfs2(arr, i, j, n);
            }
        }
        System.out.println(count);
        System.out.println(houseCnt);
    }

    public static int[][] visited;
    public static int houseCnt=0;
    public static int[] houseArr;
    public static int count = 0;
    public static void bfs2(int[][] a, int x, int y, int n){
        if(visited[x][y] == 1)
            return;
        visited[x][y] = 1;
        if(a[x][y] ==1){
            if(x != 0)
                bfs2(a, x-1, y, n);
            if(y != 0)
                bfs2(a, x, y-1,n);

            bfs2(a,x+1,y,n);
            bfs2(a, x, y+1, n);
            houseCnt++;
        }
    }
    public static void main2606(){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        int[] visited = new int[n+1];
        for(int i = 0; i<k; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        bfs(1, arr, visited, n);

        System.out.println(cnt-1);
    }

    public static int cnt = 0;
    public static void bfs(int start, int[][] arr, int[] visited, int node){

        visited[start] = 1;
        cnt++;
        for (int i = 1; i<=node; i++){
            if(arr[start][i] == 1 && visited[i] != 1){
                bfs(i, arr, visited, node);
            }
        }
    }
    public static void main1039() throws IOException{
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//
//        System.out.println(2/10);
//
//        //n에서 가장 작은 수가 맨 앞자리
//        //k 번 반벅을 해야하므로 그다음 자리, 작은 수와 변환 => k는 자릿수를 뜻함
//        int tn = n;
//        for(int i = 1; i<=k; i++){
//            //첫번째 자리와 자릿값
//            //i가 0이면 수 그대로
//            //i가 일이면 첫번째 날리고
//            int cnt = 0;
//            int fv;
//            int min = Integer.MAX_VALUE;
//            int minIndex = -1;
//            for(int a = tn; a!=0; a/=10){
//                cnt++; //자릿수
//                if(a == tn)
//                    continue;
//                if(a<10)
//                    fv = a;
//                else
//                    fv = (int) (tn / (Math.pow(10, (cnt-1))));
//                if(min > fv){
//                    min = fv; //자릿수중 최솟값
//                    minIndex = cnt;
//                }
//            }
//            System.out.println(cnt);
//            int fn = (int) (tn / (Math.pow(10, (cnt-1)))); // 제일 큰 자리수의 자리값
//            System.out.println(fn);
//            System.out.println(tn);
//            System.out.println(min);
//            System.out.println(minIndex);
//
//            //제일 큰 자릿수의 값과 제일 작은 자릿값과 자릿수 변경
//            //pow(10, cnt)의 숫자와 pow(10, minIndex)의 숫자 min과 위치 변경
//            //본래 수에 작은 자리 숫자 빼기
////            int minNumber =
//
//            tn %= 10;
//        }
        String[] strArr = sc.next().split("");
        int k = sc.nextInt();
        //k는 확인해야하는 횟수
        int fn;
        int i = 0;
        while(i < k){
            //변경 목적인 자릿값
            fn = Integer.parseInt(strArr[i]);
            int max = Integer.MIN_VALUE;
            int minIndex = -1;
            int tn;
            for(int a = i+1; a< strArr.length; a++){
                tn = Integer.parseInt(strArr[a]);
                if(tn > max){
                    max = tn;
                    minIndex = a;
                }else if(tn == max){
                    minIndex = a;
                }
            }
            if(minIndex == -1)
                continue;
            if(max > fn){
                int tmp = fn;
                strArr[i] = Integer.toString(max);
                strArr[minIndex] = Integer.toString(tmp);
                i++;
            }
        }

        for(i =0; i<strArr.length; i++){
            System.out.print(strArr[i]);
        }
    }
    public static void main10844() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][9];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int result = recur(n, 1, dp);

        System.out.println(result);
    }
    public static int recur(int digit, int value, int[][] dp){
        if(digit == 1)
            return 1;
        if(value == 0){
            dp[digit][value] = recur(digit-1, 1, dp);
        } else if (value == 9) {
            dp[digit][value] = recur(digit-1, 8, dp);
        }
        else {
            dp[digit][value] = recur(digit-1, value-1, dp) + recur(digit-1, value+1, dp);
        }
        return dp[digit][value];
    }

    public static void main1912() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] a = new int[n+1];
        int[] dp = new int[n+1];
        int max = Integer.MIN_VALUE;
        for(int i =1; i<=n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=n; i++){
            dp[i] = Math.max(a[i], a[i] + dp[i-1]);
            if(max < dp[i]){
                max = dp[i];
            }
        }
        System.out.println(max);
    }
    public static void main11066(){
        int tc = sc.nextInt();

        for(int i = 0; i<tc; i++){
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int a = 0; a<n; a++){
                arr[i] = sc.nextInt();
            }

            int sum = 0;
            int totalsum =0;
            for(int a = 0; a<n; a++){
                sum += arr[a];
//                sum += arr[a+1];
                if(a % 2 ==0){
                    totalsum +=sum;
                    sum = 0;
                }
            }
            System.out.println(totalsum * 2);
        }
    }
    public static void form(){
        /*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
	 int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        int[] visited = new int[n+1];
        for(int i = 0; i<k; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

       bfs(1, arr, visited, n);

        System.out.println(cnt-1);
 }
  public static int cnt = 0;
    public static void bfs(int start, int[][] arr, int[] visited, int node){

        visited[start] = 1;
        cnt++;
        for (int i = 0; i<node; i++){
            if(arr[start][i] == 1 && visited[i] != 1){
                bfs(i, arr, visited, node);
            }
        }
    }

}
         */
    }
    public static void main1541() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] substraction = br.readLine().split("-");
        int sum = 0;

        for(int i =0; i<substraction.length; i++){
            String[] addition = substraction[i].split("\\+");

            int add = 0;
            for(int a = 0; a<addition.length; a++){
                add += Integer.parseInt(addition[a]);
            }
            if(i == 0){
                sum += add;
            }
            else {
                sum -= add;
            }
        }

        System.out.println(sum);
    }

    public static void main11399(){
        int n = sc.nextInt();
        int[] p = new int[n];
        for(int i = 0; i<n; i++){
            p[i] = sc.nextInt();
        }
        /*
        p를 오름차순 정렬 한 후, 인덱스를 도출
         */
        Arrays.sort(p);

        System.out.println(Arrays.toString(p));

        int sum = 0;
        int totalSum = 0;
        for(int i = 0; i<n; i++){
            sum += p[i];
            totalSum += sum;
        }

        System.out.println(totalSum);
    }
    public static void main1931(){
        int n = sc.nextInt();
        int[] cd = new int[n];

        //두개의 수를 입력 받음 시작시간, 끝나는 시간, 최대 회의 갯수 구하기
//        1 4
//        3 5
//        0 6
//        5 7
//        3 8
//        5 9
//        6 10
//        8 11
//        8 12
//        2 13
//        12 14
        /*
        첫 시작부터 돌리기
        cd[1] =4
        cd[4] = > 수 존재하지 않음
        cd[5]존재
        cd[5] = 7
        cd[7] => 존재하지 않음
        cd[8] 존재
        cd[8] = 11또는 12가 있다 -> 작은 수 선택
        cd[11] => 존재하지 않음
        cd[12] 존재
        cd[12][14] -> 마지막으로 입력 받은 수이다 -> cd 크기가 시작한 시간으로 정의?
        param (시작 함수)
         */
        for(int i=0; i<n; i++){

        }
    }
    public static void main13460(){
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        char[][] charArr = new char[m][n];

        for(int i = 0; i<m;  i++){
            String s = sc.next();
            for(int j = 0; j<n; j++){
                charArr[i][j] = s.charAt(j);
            }
        }

        System.out.println(Arrays.deepToString(charArr));
    }
    public static void execute(){
        b1();
        b2();
    }

    public static void b1(){
        if(a == 0){
            a +=1;
            System.out.println(a);
        }else{
            System.out.println("a changed");
        }
    }

    public static void b2(){
        if(a == 0){
            a +=1;
            System.out.println(a);
        }else{
            System.out.println("a changed");
        }
    }
}
