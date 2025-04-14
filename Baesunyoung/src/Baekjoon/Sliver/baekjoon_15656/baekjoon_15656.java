package Baekjoon.Sliver.baekjoon_15656;

import java.io.*;
import java.util.*;

public class baekjoon_15656 {
	static int N, M;
	 static int[] input;
	 static int[] result;
	
	 static StringBuilder sb = new StringBuilder(); 
	 public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        
	        input = new int[N];
	        result = new int[M];

	        st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < N; i++) {
	            input[i] = Integer.parseInt(st.nextToken());
	        }

	        Arrays.sort(input); // 사전 순 출력을 위해 정렬
	        backtracking(0);

	        System.out.print(sb);
	    }

	    public static void backtracking(int depth) {
	        if (depth == M) {
	            for (int i = 0; i < M; i++) {
	                sb.append(result[i]).append(" ");
	            }
	            sb.append("\n");
	            return;
	        }

	        for (int i = 0; i < N; i++) {
	        	 result[depth] = input[i];
	        	 backtracking(depth + 1);
	        }
	    }    
	}

