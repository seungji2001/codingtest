package com.example.codingtest.PriorityQueue;
import java.util.*;

class Data{
    int k;
    int v;
    public Data(int k, int v){
        this.k = k;
        this.v = v;
    }

    public String toString(){
        String str = "k " + k + " v " + v;
        return str;
    }

}


    class PriorityQueueProgrammers {
        public int solution(int[] priorities, int location) {
            int answer = 0;

            //중요도에 따른 인덱스를 집어넣기
            //중요도가 가장 큰 순으로 중요도 해당 인덱스 나열
            PriorityQueue<Data> pq = new PriorityQueue<Data>(
                    new Comparator<>(){
                        @Override
                        public int compare(Data o1, Data o2) {
                            return o1.v - o2.v;
                        }
                    }
            );

            for(int i = 0; i<priorities.length; i++){
                //여기서 조작하기

                pq.add(new Data(i, priorities[i]));
            }


            int count = 0;
            while(!pq.isEmpty()){
                count++;
                Data data = pq.poll();
                System.out.println(data + " " + count);
                if(data.k == location){
                    return count;
                }
            }

            return count;
        }
    }

