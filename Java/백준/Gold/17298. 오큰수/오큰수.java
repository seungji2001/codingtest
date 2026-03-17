import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
/*
4
3 5 2 7

5 7 7 -1
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim()); // 4
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 3 5 2 7
        }

        //스택에 인덱스 넣기
        //값이랑 비교하다 현재 값보다 스택에 있는 값이 작을 경우 현재 값 넣기

        int[] answer = new int[n];
        Arrays.fill(answer, -1); // 미리 -1로 초기화
        
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] < arr[i]){
                int idx = s.pop();
                answer[idx] = arr[i];
            }
            s.push(i); //0 1 
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]);
            if (i < answer.length - 1) sb.append(" ");
        }
        System.out.println(sb);
    }
}