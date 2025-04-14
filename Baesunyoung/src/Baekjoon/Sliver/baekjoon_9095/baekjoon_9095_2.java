package Baekjoon.Sliver.baekjoon_9095;

import java.io.*;
import java.util.*;

public class baekjoon_9095_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
			
		while(T-- > 0) {
			 int N = Integer.parseInt(br.readLine()); // 각 테스트 케이스마다 N 입력받음
			 System.out.println(solution(N));
		}

	}
	
	public static int solution(int n) {
		if(n == 0) return 1;
		if(n < 0) return 0;
		
		return solution(n - 1) + solution(n - 2) + solution(n - 3);
	}
}
