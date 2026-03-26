import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*

양치기 꿍은 맨날 늑대가 나타났다고 마을 사람들을 속였지만 이젠 더이상 마을 사람들이 속지 않는다. 
화가 난 꿍은 복수심에 불타 아예 늑대들을 양들이 있는 울타리안에 마구 집어넣어 양들을 잡아먹게 했다.

하지만 양들은 보통 양들이 아니다. 같은 울타리 영역 안의 양들의 숫자가 늑대의 숫자보다 더 많을 경우 늑대가 전부 잡아먹힌다.
물론 그 외의 경우는 양이 전부 잡아먹히겠지만 말이다.

꿍은 워낙 똑똑했기 때문에 이들의 결과는 이미 알고있다. 
만약 빈 공간을 '.'(점)으로 나타내고 울타리를 '#', 늑대를 'v', 양을 'k'라고 나타낸다면 여러분은 몇 마리의 양과 늑대가 살아남을지 계산할 수 있겠는가?

단, 울타리로 막히지 않은 영역에는 양과 늑대가 없으며 양과 늑대는 대각선으로 이동할 수 없다.

입력
입력의 첫 번째 줄에는 각각 영역의 세로와 가로의 길이를 나타내는 두 개의 정수 R, C (3 ≤ R, C ≤ 250)가 주어진다.

다음 각 R줄에는 C개의 문자가 주어지며 이들은 위에서 설명한 기호들이다.

출력
살아남게 되는 양과 늑대의 수를 각각 순서대로 출력한다.

예제 입력 1 
6 6
...#..
.##v#.
#v.#.#
#.k#.#
.###.#
...###
예제 출력 1 
0 2
*/
public class Main {
    public static int[] drow = {-1, 1, 0, 0};
    public static int[] dcol = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] st = br.readLine().split(" ");
        int r = Integer.parseInt(st[0]);
        int c = Integer.parseInt(st[1]);

        char[][] box = new char[r][c];
        for(int i = 0; i<r; i++){
            box[i] = br.readLine().toCharArray();
        }
        
        boolean[][] visited = new boolean[r][c];
        int vcnt = 0;
        int kcnt = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                // 방문 안 했고 빈칸이나 동물인 경우 (벽 제외)
                if(!visited[i][j] && box[i][j] != '#'){
                    int[] result = new int[2]; // [vcnt, kcnt]
                    dfs(box, visited, result, i, j);
                    // 영역 탐색 끝난 후 판단
                    if(result[0] < result[1]){
                        kcnt += result[1];  // 양 승리
                    } else {
                        vcnt += result[0];  // 늑대 승리
                    }
                }
            }
        }

        System.out.println(kcnt + " " + vcnt);
    }

    public static void dfs(char[][] b, boolean[][] visited, int[] result, int cr, int cc){
        if(visited[cr][cc]) return;
        visited[cr][cc] = true;
    
        if(b[cr][cc] == 'v') result[0]++;
        if(b[cr][cc] == 'k') result[1]++;
    
        for(int i = 0; i < 4; i++){
            int nr = cr + drow[i];
            int nc = cc + dcol[i];  // ✅ dcol로 수정
            if(nr>=0 && nr<b.length && nc>=0 && nc<b[0].length){
                if(b[nr][nc] != '#' && !visited[nr][nc]){
                    dfs(b, visited, result, nr, nc);
                }
            }
        }
    }
}