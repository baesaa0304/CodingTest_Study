package Baekjoon.Gold.baekjoon_14391;

import java.io.*;
import java.util.*;

public class baekjon_14391 {
	 static int N, M;
	    static int[][] board;
	    static int max = 0;

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        
	        board = new int[N][M];
	        for (int i = 0; i < N; i++) {
	            String line = br.readLine();
	            for (int j = 0; j < M; j++) {
	                board[i][j] = line.charAt(j) - '0';
	            }
	        }

	        int total = 1 << (N * M); // 비트마스크: 각 칸을 가로 or 세로로 자를지 결정
	        for (int mask = 0; mask < total; mask++) {
	            max = Math.max(max, getSum(mask));
	        }

	        System.out.println(max);
	    }

	    static int getSum(int mask) {
	        int sum = 0;

	        // 가로 조각 합
	        for (int i = 0; i < N; i++) {
	            int temp = 0;
	            for (int j = 0; j < M; j++) {
	                int idx = i * M + j;
	                if ((mask & (1 << idx)) == 0) { // 가로
	                    temp = temp * 10 + board[i][j];
	                } else {
	                    sum += temp;
	                    temp = 0;
	                }
	            }
	            sum += temp;
	        }

	        // 세로 조각 합
	        for (int j = 0; j < M; j++) {
	            int temp = 0;
	            for (int i = 0; i < N; i++) {
	                int idx = i * M + j;
	                if ((mask & (1 << idx)) != 0) { // 세로
	                    temp = temp * 10 + board[i][j];
	                } else {
	                    sum += temp;
	                    temp = 0;
	                }
	            }
	            sum += temp;
	        }

	        return sum;
	    }
}
