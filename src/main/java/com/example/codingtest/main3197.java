package com.example.codingtest;

import java.io.*;
import java.util.*;

public class main3197 {

    static int r,c,ex,ey;
    static char[][] map;
    static boolean[][] check;
    static Queue<int[]> wq,sq;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        wq = new LinkedList<>();
        sq = new LinkedList<>();
        int sx = -1, sy = -1;
        int idx=0;
        for(int i=0; i<r; i++) {
            String line = br.readLine();
            for(int j=0; j<c; j++) {
                map[i][j] = line.charAt(j);
                //입력을 받으면서 백조의 위치 검사하기
                if(map[i][j] == 'L') {
                    //만약 초기 상황, 이동하지 않은 경우라면 해당 백조의 위치를
                    //sx, sy로 저장을 한다
                    if(sx==-1 && sy==-1) {
                        sx = j;
                        sy = i;
                        //ex, ey는 첫번째 발견 L과 다른 L의 위치이다
                    }else {
                        //만약 그렇지 않다면, ex, ey에 저장을 한다
                        ex = j;
                        ey = i;
                    }
                    //그리고 해당 백조의 위치를 .으로 변경을 한다
                    map[i][j] ='.';
                }

                //만약 해당 위치가 . 이라면 wq에 [j. i] 를 넣는다
                if(map[i][j] == '.') {
                    //queue는 .이었던 x, y의 위치가 기록으로 나와져 있다
                    wq.add(new int[] {j,i});
                }
            }
        }

        //check[r][c] 생성
        check = new boolean[r][c];
        //sx, sy는 L의 초기 위치로 sq에 넣는다
        sq.add(new int[] {sx,sy});
        //초기 L의 sy, sx 위치를 check에 true로 저장해둔다
        check[sy][sx] = true;

        int time=0;
        while(true) {
            if(move()) break;
            melting();
            time++;

        }
        System.out.println(time);
    }

    //
    static boolean move() {
        Queue<int[]> q = new LinkedList<>();

        //sq가 비어있지 않다면 -> 첫번째 L이 방문할 수 있는 L을 모두 탐색할때까지
        while(!sq.isEmpty()) {
            //sq의 초기 위치 p[x, y]로 저장한다
            int[] p = sq.poll();
            int px = p[0], py = p[1];
            //두개의 L이 만난다면
            if(px == ex && py == ey) {
                return true;
            }

            for(int i=0; i<4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx <0 || ny<0 || nx>c-1 || ny>r-1 || check[ny][nx]) continue;

                check[ny][nx] = true;
                if(map[ny][nx] == '.') {
                    sq.add(new int[] {nx,ny});
                }else if(map[ny][nx] == 'X') { // 다음 탐색지역
                    q.add(new int[] {nx,ny});
                }
            }
        }

        //sq는X의 위치가 있다
        sq = q;
        return false;
    }

    static void melting() {
        int size = wq.size();
        for(int i=0; i<size; i++) {
            int[] p = wq.poll();

            for(int d=0; d<4; d++) {
                int nx = p[0] + dx[d];
                int ny = p[1] + dy[d];

                if(nx <0 || ny<0 || nx>c-1 || ny>r-1) continue;
                if(map[ny][nx] == 'X') {
                    map[ny][nx] = '.';
                    wq.add(new int[] {nx,ny});
                }
            }
        }
    }
}