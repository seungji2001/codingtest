package com.example.codingtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class main12100 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        /*
        2 2 2
        4 4 4
        8 8 8
         */
        //위아래, 옆에 같은 숫자가 있는 경우 해볼 수 있다
        //검사 메소드

        //1 - 위, 2 - 오른쪽, 3- 아래, 4 - 왼쪽
        checkCombine(arr, 1);
//        if(checkCombine(arr, 1)) {
//            arr = combineArray(arr, 1);
//        }
    }

    public static void checkCombine(int[][] a, int way){
        if(way == 1){
            //위로 이동 가능핮니 확인하기
            //두개 같은 수가 있어야한다
            /*
            2 2 4
            2 4 4
            4 2 4
             */
            for(int i = 0; i<a[0].length; i++){
//                a[i][0] 이랑 a[i+1][0] 이랑 같은 수인지 확인
                if(a[i][0] == a[i+1][0]){
//                    합쳐지는거 가능핮
                    a[i][0] += a[i+1][0];
                }
            }
        }
    }

}
