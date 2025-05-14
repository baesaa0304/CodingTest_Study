package Baekjoon.Sliver.baekjoon_11724;


import java.io.*;
import java.util.*;

public class baekjoon_11724_DFS {
	
	static int N;
	static int M;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int cnt;
	 public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u); // 무방향
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFS(i);
                cnt++;
            }
        }
        System.out.println(cnt);
		
	}
	
	 public static void DFS(int n) {
	        visited[n] = true;
	        for (int next : graph.get(n)) {
	            if (!visited[next]) {
	                DFS(next);
	            }
	        }
	    }
	 
}
