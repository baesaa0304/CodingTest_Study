package Baekjoon.Silver.No10971_TSP2;

import java.io.*;
import java.util.*;

public class No10971_TSP2Wrong {

	static int n;
	static int result = Integer.MAX_VALUE;
	static int[][] w;
	static int[] selected;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader( new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		selected = new int[n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(result);
		

	}

	private static void dfs(int depth) {
		if(depth == n) {
			int sum = 0;
			for(int i = 0; i < n-1; i++) {
				sum += w[selected[i]][selected[i+1]];
			}
			result = Math.min(result, sum);
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[depth] = i;
				dfs(depth + 1);
				visited[i]= false;
			}
		}
		
	}

}
