package Baekjoon.Gold.baekjoon_1248;

import java.io.*;
import java.util.*;

public class baekjoon_1248 {
    static int N;
    static char[][] sign;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        sign = new char[N][N];
        a = new int[N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sign[i][j] = s.charAt(idx++);
            }
        }

        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(a[i] + " ");
            }
            System.exit(0);
        }

        for (int num = -10; num <= 10; num++) {
            a[depth] = num;
            if (check(depth)) {
                dfs(depth + 1);
            }
        }
    }

    static boolean check(int depth) {
        for (int i = 0; i <= depth; i++) {
            int sum = 0;
            for (int j = i; j <= depth; j++) {
                sum += a[j];
            }

            if ((sign[i][depth] == '+' && sum <= 0) ||
                (sign[i][depth] == '-' && sum >= 0) ||
                (sign[i][depth] == '0' && sum != 0)) {
                return false;
            }
        }
        return true;
    }
}