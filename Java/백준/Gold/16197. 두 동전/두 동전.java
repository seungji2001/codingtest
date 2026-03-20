import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Main {
    static int N, M;
    static char[][] board;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        board = new char[N][M];
        int r1 = -1, c1 = -1, r2 = -1, c2 = -1;
        int coinCount = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'o') {
                    if (coinCount == 0) { r1 = i; c1 = j; }
                    else               { r2 = i; c2 = j; }
                    coinCount++;
                }
            }
        }

        System.out.println(bfs(r1, c1, r2, c2));
    }

    static int bfs(int r1, int c1, int r2, int c2) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new int[]{r1, c1, r2, c2, 0});
        visited.add(r1 + "," + c1 + "," + r2 + "," + c2);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr1 = cur[0], cc1 = cur[1];
            int cr2 = cur[2], cc2 = cur[3];
            int cnt = cur[4];

            if (cnt >= 10) continue;

            for (int d = 0; d < 4; d++) {
                // 동전1 이동
                int nr1 = cr1, nc1 = cc1;
                boolean out1 = false;
                int tr1 = cr1 + dr[d], tc1 = cc1 + dc[d];
                if (tr1 < 0 || tr1 >= N || tc1 < 0 || tc1 >= M) {
                    out1 = true;
                } else if (board[tr1][tc1] != '#') {
                    nr1 = tr1; nc1 = tc1;
                }

                // 동전2 이동
                int nr2 = cr2, nc2 = cc2;
                boolean out2 = false;
                int tr2 = cr2 + dr[d], tc2 = cc2 + dc[d];
                if (tr2 < 0 || tr2 >= N || tc2 < 0 || tc2 >= M) {
                    out2 = true;
                } else if (board[tr2][tc2] != '#') {
                    nr2 = tr2; nc2 = tc2;
                }

                // 정답: 정확히 하나만 떨어진 경우
                if (out1 && !out2) return cnt + 1;
                if (!out1 && out2) return cnt + 1;
                if (out1 && out2) continue;

                String key = nr1 + "," + nc1 + "," + nr2 + "," + nc2;
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(new int[]{nr1, nc1, nr2, nc2, cnt + 1});
                }
            }
        }
        return -1;
    }
}