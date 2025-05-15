package Baekjoon.Gold.baekjoon_1707;

import java.io.*;
import java.util.*;

public class baekjoon_1707DFS {
	static int K;
	static int V;
	static int E;
	static List<List<Integer>> arr = new ArrayList<>();
	static boolean[] visited;
	static int[] color;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    K = Integer.parseInt(br.readLine());

	    StringBuilder sb = new StringBuilder();

	    for (int test = 0; test < K; test++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        V = Integer.parseInt(st.nextToken());
	        E = Integer.parseInt(st.nextToken());

	        // 그래프, 방문 배열, 색 배열 초기화
	        arr = new ArrayList<>();
	        for (int i = 0; i <= V; i++) {
	            arr.add(new ArrayList<>());
	        }

	        visited = new boolean[V + 1];
	        color = new int[V + 1];

	        // 간선 입력
	        for (int i = 0; i < E; i++) {
	            st = new StringTokenizer(br.readLine());
	            int u = Integer.parseInt(st.nextToken());
	            int v = Integer.parseInt(st.nextToken());

	            arr.get(u).add(v);
	            arr.get(v).add(u);
	        }

	        boolean isBipartite = true;
	        for (int i = 1; i <= V; i++) {
	            if (!visited[i]) {
	            	if (!DFS(i, 0)) {  // 첫 정점 색깔을 0으로 시작
	            	    isBipartite = false;
	            	    break;
	            	}
	            }
	        }

	        if (isBipartite) {
	            sb.append("YES\n");
	        } else {
	            sb.append("NO\n");
	        }
	    }

	    System.out.print(sb.toString());
	}
	
	public static boolean DFS(int node, int c) {
	    visited[node] = true;
	    color[node] = c;

	    for (int next : arr.get(node)) {
	        if (!visited[next]) {
	            if (!DFS(next, 1 - c)) {
	                return false;
	            }
	        } else {
	            if (color[next] == color[node]) {
	                return false;
	            }
	        }
	    }

	    return true;
	}
	

}
