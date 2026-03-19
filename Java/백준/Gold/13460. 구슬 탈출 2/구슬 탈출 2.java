import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    static char[][] box;
    static int rowSize, colSize;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        rowSize = Integer.parseInt(nk[0]);
        colSize = Integer.parseInt(nk[1]);

        box = new char[rowSize][colSize];
        int rr = 0, rc = 0, br2 = 0, bc = 0;

        for (int i = 0; i < rowSize; i++) {
            String s = br.readLine();
            box[i] = s.toCharArray();
            for (int j = 0; j < colSize; j++) {
                if (box[i][j] == 'R') { rr = i; rc = j; box[i][j] = '.'; }
                if (box[i][j] == 'B') { br2 = i; bc = j; box[i][j] = '.'; }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new int[]{rr, rc, br2, bc, 0});
        visited.add(rr + "," + rc + "," + br2 + "," + bc);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRr = cur[0], curRc = cur[1];
            int curBr = cur[2], curBc = cur[3];
            int count = cur[4];

            if (count >= 10) continue;

            for (int d = 0; d < 4; d++) {
                int[] newR = roll(curRr, curRc, dr[d], dc[d]);
                int[] newB = roll(curBr, curBc, dr[d], dc[d]);

                // 파란 공이 구멍에 빠지면 무효
                if (newB == null) continue;

                // 빨간 공이 구멍에 빠지면 성공
                if (newR == null) {
                    System.out.println(count + 1);
                    return;
                }

                // 두 공이 같은 위치에 있으면 더 많이 굴러간 공을 한 칸 뒤로
                if (newR[0] == newB[0] && newR[1] == newB[1]) {
                    int rDist = Math.abs(newR[0] - curRr) + Math.abs(newR[1] - curRc);
                    int bDist = Math.abs(newB[0] - curBr) + Math.abs(newB[1] - curBc);
                    if (rDist > bDist) {
                        newR[0] -= dr[d];
                        newR[1] -= dc[d];
                    } else {
                        newB[0] -= dr[d];
                        newB[1] -= dc[d];
                    }
                }

                String key = newR[0] + "," + newR[1] + "," + newB[0] + "," + newB[1];
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(new int[]{newR[0], newR[1], newB[0], newB[1], count + 1});
                }
            }
        }

        System.out.println(-1);
    }

    static int[] roll(int r, int c, int dr, int dc) {
        while (true) {
            int nr = r + dr;
            int nc = c + dc;
            if (nr < 0 || nr >= rowSize || nc < 0 || nc >= colSize) return new int[]{r, c};
            if (box[nr][nc] == '#') return new int[]{r, c};
            if (box[nr][nc] == 'O') return null;
            r = nr;
            c = nc;
        }
    }
}