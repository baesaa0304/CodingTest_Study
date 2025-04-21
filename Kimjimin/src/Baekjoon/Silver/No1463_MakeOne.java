
package Baekjoon.Silver;

import java.util.Scanner;

public class No1463_MakeOne {
	
	// dp 메서드와 main에서 사용
	static Integer[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// dp배열 설정
		dp = new Integer[n + 1];
		dp[0] = dp[1] = 0;
		
		System.out.println(dynamic(n));
		
		
	}

	/*
	 * dp 재귀 함수 dynamic, dp[] 이름 dp.
	 *  dp[i] = min(dp[n/2], dp[n/3], dp[n -1])+1 ==
	 * dp[i] = min(dynamic(n/2), dynamic(n/3), dynamic(n -1))+1 
	 *  n % 2 == 0 => /2 , -1 경우 재귀 호출 
	 *  n % 3 ==0 => /3, -1 경우 재귀 호출
	 *  n % 6 ==0 => 3개 연산 경우 다 재귀호출
	 */
	static int dynamic(int n) {
		
		if(dp[n] == null) {
			if(n % 6 == 0) {
				dp[n] = Math.min(dynamic(n-1), Math.min(dynamic(n/2), dynamic(n/3))) + 1;
			}else if(n % 3 == 0) {
				dp[n] = Math.min(dynamic(n/3), dynamic(n-1)) + 1;
			}else if(n % 2 == 0) {
				dp[n] = Math.min(dynamic(n/2), dynamic(n-1)) + 1;
			}
			// 이외 -1 연산만 하는 경우
			else {
				dp[n] = dynamic(n-1) + 1;
			}
		}
		return dp[n];
	}

}
