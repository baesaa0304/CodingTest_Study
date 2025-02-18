package Baekjoon.Sliver.baekjoon_1309;

import java.io.*;

public class baekjoon_1309Wrong {
	
	static final int MOD = 9901;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(solution(N));
		
	}
	
	public static int solution(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 3;

		for(int i = 2; i <= n; i++) {
			dp[i] = ((dp[i - 1] * 2) + dp[i - 2]) % MOD;
		}
		int answer = dp[n];
		return answer;
	}
}
