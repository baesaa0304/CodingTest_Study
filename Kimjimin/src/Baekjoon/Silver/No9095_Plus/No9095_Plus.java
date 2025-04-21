package Baekjoon.Silver.No9095_Plus;

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
			
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for(int i = 4; i <= n; i++){
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			bw.write(dp[n] + "\n");
		}
		bw.flush();
		bw.close();

	}

}