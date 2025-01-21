package Baekjoon.Silver;

import java.util.Scanner;

public class No11726_2xnTiling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// DP 배열 선언
		int[] dp = new int[n+1];
		
		// dp 초기값 설정
		dp[1] = 1;
		dp[2] = 2;
		
		// dp 구하는 코드
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			System.out.println("확인:" + dp[i]);
		}
		System.out.println("최종 확인:" + dp[n]);
		int result = dp[n] % 10007;
		System.out.println(result);
				

	}

}
