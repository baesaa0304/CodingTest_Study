package Baekjoon.Sliver.baekjoon_15665;

import java.util.*;
import java.io.*;

public class baekjoon_15665 {
	static int N, M;
	static int[] input;
	static int[] result;
	
	static StringBuilder sb = new StringBuilder(); // 출력 속도 향상
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringTokenizer st = new StringTokenizer(br.readLine());
	       N = Integer.parseInt(st.nextToken());
	       M = Integer.parseInt(st.nextToken());
	
	       // 수열 입력
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
	    	    // 중복 숫자가 연속해서 나올 경우 같은 depth에서는 사용하지 않기
	    	    if (i > 0 && input[i] == input[i - 1]) continue;
	    	    result[depth] = input[i];
	    	    backtracking(depth + 1);
	       }
	   }    
	}

