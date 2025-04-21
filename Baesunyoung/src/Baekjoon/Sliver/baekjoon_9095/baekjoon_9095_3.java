package Baekjoon.Sliver.baekjoon_9095;

import java.io.*;

public class baekjoon_9095_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int M = Integer.parseInt(br.readLine());
			System.out.println(solution(M));
		}
	}
	
	// 재귀를 통해 풀었음 
	public static int solution(int n) {
		if(n == 0) return 1;
		if(n < 0) return 0;
		return solution(n - 1) + solution(n - 2) + solution(n - 3);
	}
}
