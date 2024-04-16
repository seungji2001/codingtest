package com.example.codingtest.Queue;
import java.util.*;
public class Programmers_scoville {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;


            //모든 scoville안의 지수가 k이상이 되어야한다
            //지수를 올리는 방법으로는 scoville 안의 작은 음식 + 두번째 +2 방법으로 만든다

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i = 0; i<scoville.length; i++){
                pq.add(scoville[i]);
            }

            int cnt = 0;
            while(!pq.isEmpty()){
                if(pq.peek()<K && pq.size()>=2){
                    //더하는 경우
                    int first = pq.poll();
                    int second = pq.poll();


                    int newScoville = first + second * 2;

                    pq.add(newScoville);
                    cnt++;
                }else if(pq.peek()>=K){
                    pq.poll();
                }else{
                    return -1;
                }
            }


            System.out.println(cnt);

            answer = cnt;
            return answer;
        }
    }
}
