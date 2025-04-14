package Baekjoon.Sliver.baekjoon_1912;


import java.io.*;
import java.util.*;

public class baakjoon_1912_wrong {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] = new int[N];
		int maxsum = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0]= arr[0];
		int cur = arr[0];
		maxsum = arr[0];
		
		for(int i = 1; i < N; i++) {
			if(dp[i - 1] <  cur + arr[i]) {
				cur+= arr[i];
				System.out.println("cur 후 = " + cur);
				dp[i] =  cur;
			}
			else {
				maxsum = Math.max(maxsum, cur);
				System.out.println("maxsum = "+ maxsum);
				cur = 0; // 0으로 초기화 
			}
		}
	}
}
