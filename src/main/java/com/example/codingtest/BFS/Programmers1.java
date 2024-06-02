package com.example.codingtest.BFS;

import java.util.*;
import java.io.FileInputStream;


class Solution {
    public static int max;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int L = sc.nextInt();

            int[] t = new int[N];
            int[] k = new int[N];

            for (int i = 0; i < N; i++) {
                t[i] = sc.nextInt();
                k[i] = sc.nextInt();
            }

            max = 0;
            List<Integer> list = new ArrayList<>();
            pick(0, t, k, N, L, list, 0);

            System.out.println("#" + test_case + " " + max);
        }
    }

    public static void pick(int idx, int[] t, int[] k, int N, int L, List<Integer> v, int sum) {
        if (sum > L) {
            return;
        }

        int tSum = 0;
        for (int i : v) {
            tSum += t[i];
        }
        max = Math.max(max, tSum);

        for (int i = idx; i < N; i++) {
            v.add(i);
            pick(i + 1, t, k, N, L, v, sum + k[i]);
            v.remove(v.size() - 1);
        }
    }
}