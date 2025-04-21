package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No14002_Subsequence4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lis = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            lis = Math.max(lis, dp[i]);
            System.out.println("lis 확인: " + lis);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis).append("\n");

        Stack<Integer> store = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == lis) {
                store.push(arr[i]);
                lis--;
            }
        }

        while (!store.empty()) {
            sb.append(store.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
