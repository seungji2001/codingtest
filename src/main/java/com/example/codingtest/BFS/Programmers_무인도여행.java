package com.example.codingtest.BFS;
import java.util.*;
public class Programmers_무인도여행 {
    class Solution {

        //한 섬당 연결되어있는지 확인 필요하다
        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};
        int[][] visited;
        int sum = 0;

        public ArrayList<Integer> solution(String[] maps) {
            ArrayList<Integer> answer = new ArrayList<Integer>();
            visited = new int[maps.length][maps[0].length()];
            //붙어있는 곳에 숫자 발견시 값을 더해 나가면서 + 방문안한 지역이어야한다
            //더해나가면서 더이상 숫자가 없으면 값을 리턴한다

            for(int i = 0; i<maps.length; i++){
                for(int j = 0; j<maps[0].length(); j++){
                    if(visited[i][j] == 1){
                        continue;
                    }
                    if(maps[i].charAt(j) != 'X'){
                        sum = Integer.parseInt(String.valueOf(maps[i].charAt(j)));
                        getAroundValue(maps, i, j);
                        System.out.println(sum);
                        answer.add(sum);
                        sum = 0;
                    }
                    visited[i][j] = 1;
                }
            }

            if(answer.size() == 0){
                answer.add(-1);
            }

            Collections.sort(answer);

            return answer;
        }

        public void getAroundValue(String[] maps,int i, int j){
            //현재 확인 시작한 위치 maps[i][j] , 숫자이다
            visited[i][j] = 1;
            for(int k = 0; k<4; k++){
                //확인하기
                int y_check = i + dy[k];
                int x_check = j + dx[k];

                if(y_check>=0 && y_check<maps.length && x_check>=0 && x_check<maps[0].length()){
                    if(maps[y_check].charAt(x_check) != 'X' && visited[y_check][x_check] != 1){
                        sum += Integer.parseInt(String.valueOf(maps[y_check].charAt(x_check)));
                        getAroundValue(maps,y_check, x_check);
                    }
                }
            }
        }

    }

}
