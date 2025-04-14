package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17087_HideAndSeek {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 동생들
		int n = Integer.parseInt(st.nextToken());
		// 시작점 
		int s = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[n];
		st = new StringTokenizer(br.readLine());
		// 각 동생들의 위치 - 시작점.
		for(int i = 0; i < n; i++) {
			int location = Integer.parseInt(st.nextToken());
			distance[i] = Math.abs(location - s);
		}
		
		int gcd = distance[0];
		for(int i = 1; i < n; i++) {
			gcd = getGcd(gcd,distance[i]);
		}
		System.out.println(gcd);		
				

	}

	private static int getGcd(int num1, int num2) {
		if(num2 == 0) return num1;
		return getGcd(num2, num1 % num2);
	}

}
