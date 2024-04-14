package com.example.codingtest;

import java.io.IOException;
import java.util.*;

public class main1655 {

    public static void RuntimeError(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        for(int i = 0; i<n; i++){
            list.add(sc.nextInt());
            Collections.sort(list);


            int middle = list.get((list.size() - 1)/2);
            result.add(middle);
        }

        for(int a:result)
            System.out.println(a);
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < n; i++) { // 1 5 2
            int a = sc.nextInt();

            if(maxHeap.size() == minHeap.size()){
                maxHeap.offer(a);
            }else{
                minHeap.offer(a);
            }

            if(!maxHeap.isEmpty() && !minHeap.isEmpty()){
                if(maxHeap.peek() > minHeap.peek()){
                    int tmp = maxHeap.poll();
                    minHeap.offer(tmp);
                    maxHeap.offer(minHeap.poll());
                }
            }

            System.out.println(maxHeap.peek());
        }
    }
}
