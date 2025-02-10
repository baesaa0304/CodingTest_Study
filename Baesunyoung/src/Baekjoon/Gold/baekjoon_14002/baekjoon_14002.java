package Baekjoon.Gold.baekjoon_14002;

import java.io.*;
import java.util.*;

public class baekjoon_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        int[] dp = new int[N];
        int[] prev = new int[N];  // LIS 역추적을 위한 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1); // 최소 길이 1
        Arrays.fill(prev, -1); // 이전 위치 초기화 (-1은 없음)

        int maxLength = 0, lastIndex = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (list[j] < list[i] && dp[i] < dp[j] + 1) {
                	//System.out.print("list[j]: " + list[j] + " ");
                	//System.out.print("list[i]: " + list[i] + " ");
                	//System.out.println();
                	//System.out.print("dp[i]: " + dp[i] + " ");
                	//System.out.print("dp[j]: " + dp[j] + " ");
                	//System.out.print("dp = " + dp[j] + 1);
                	System.out.println();
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                   // System.out.println("dp[i]" + dp[i]);
                    //System.out.println("j = " + j);
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
            
        }
       
        System.out.println(maxLength);

        // LIS 경로 복원 (스택 사용)
        Stack<Integer> stack = new Stack<>();
        while (lastIndex != -1) {
            stack.push(list[lastIndex]);
            lastIndex = prev[lastIndex];
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}