package com.example.codingtest.Queue;

import java.util.*;

public class Programmers_disk_controller {

    static class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            //작업시간이 작은것을 우선순위로 한다
            //작업시간은 jobs[][1]에 있다
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[1] - o2[1]);

            for(int i = 0; i<jobs.length; i++){
                pq.add(jobs[i]);
            }

            int time = 0;
            int spendTime = 0;
            int totalSum = 0;
            while(!pq.isEmpty()){
                int[] a = pq.poll();

                int requestTime = a[0]; //1
                int workTime = a[1]; // 9
                time += workTime; //18
                spendTime = time - requestTime;

                totalSum += spendTime;

            }

            answer = totalSum/jobs.length;

            return answer;
        }
    }
}
