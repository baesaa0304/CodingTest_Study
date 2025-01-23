package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No9095_Plus {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[11];
			
			dp[1] = 0;
			dp[2] = 1;
			for(int i = 3; i <= n; i++){
				dp[i] =  dp[i -1] + ((dp[i-1] - dp[i-2] ) + 2);
			}
			bw.write(dp[n] + "\n");
		}
		bw.flush();
		bw.close();

	}

}
