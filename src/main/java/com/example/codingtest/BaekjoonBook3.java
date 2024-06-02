package com.example.codingtest;
import java.io.*;
import java.util.*;


public class BaekjoonBook3 {
    //Invalid
    public static void main(String[] args){

    }

    public void solution3(){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }

        int max = Integer.MIN_VALUE;
        char answer = 0;
        int checkSame = 0;
        for(char c : map.keySet()){
            if(map.get(c) > max){
                max = map.get(c);
                answer = c;
                checkSame = 0;
            }else if(map.get(c) == max){
                checkSame ++;
            }
        }

        if(checkSame != 0){
            answer = '?';
        }

        System.out.println(answer);
    }

    public void soluction2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] answer = new String[]{"Equilateral", "Isosceles", "Scalene", "Invalid"};
        String s ="";
        StringBuilder sb = new StringBuilder();
        while (!(s = br.readLine()).equals("0 0 0")){
            int[] ints = Arrays.stream(s.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(ints);

            //invalid, valid
            if((ints[0] + ints[1]) <= ints[2]){
                sb.append(answer[3] + "\n");
                continue;
            }

            Set<Integer> set = new HashSet<>();
            for(int i : ints){
                set.add(i);
            }
            if(set.size() == 1){
                sb.append(answer[0] + "\n");
            }
            else if(set.size() == 2){
                sb.append(answer[1] + "\n");
            }
            else if(set.size() == 3){
                sb.append(answer[2] + "\n");
            }
        }

        System.out.println(sb);
    }
}
