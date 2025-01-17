package Baekjoon.Sliver.baekjoon_1463;

import java.io.*;

public class baekjoon_1463 {

	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        // 입력받은 수 x
	        int x = Integer.parseInt(br.readLine());

	        // dp 배열 생성 (0부터 x까지)
	        int[] dp = new int[x + 1];

	        // dp[0]과 dp[1]은 연산 횟수가 0 (1로 만들기 위해 연산이 필요 없으므로)
	        dp[0] = dp[1] = 0;

	        // 2부터 x까지 차례대로 최소 연산 횟수 계산
	        for (int i = 2; i <= x; i++) {
	            // 1을 빼는 연산
	            dp[i] = dp[i - 1] + 1;

	            // 2로 나누어지면
	            if (i % 2 == 0) {
	                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
	            }

	            // 3으로 나누어지면
	            if (i % 3 == 0) {
	                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
	            }
	        }

	        // 결과 출력 (x를 1로 만들기 위한 최소 연산 횟수)
	        System.out.println(dp[x]);
	    }
	}
