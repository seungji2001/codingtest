package com.example.codingtest.BFS;
import java.util.*;


public class ProgrammersTargetNumber {

        static int count = 0;
        public static void main(String[] args) {
            int[] numbers = {1, 1, 1, 1, 1};
            int target = 3;
            int answer = 0;

            //numbers로 target을 만들 수 있는 방법
            //- 와 + 를 사용할 수 있다
            bfs(numbers, target,-1,0);
            answer = count;

            System.out.println(answer);
        }

        public static void bfs(int[] numbers,int target,int index, int num){

            if(index == numbers.length - 1) {
                if (num == target) {
                    count++;
                }
                return;
            }
            // if(index < numbers.length){
            int addIndex = index+1;
            if(addIndex<numbers.length && addIndex>=0){
                bfs(numbers, target,addIndex, num+numbers[addIndex]);
                bfs(numbers, target, addIndex, num-numbers[addIndex]);
            }
            // }
        }
}
