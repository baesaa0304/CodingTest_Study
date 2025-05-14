package Baekjoon.Sliver.baekjoon_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_11724_BFS {
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
                BFS(i);
                cnt++;
            }
        }
        System.out.println(cnt);
		
	}
	 public static void BFS(int n) {
	        Queue<Integer> queue = new LinkedList<>();
	        visited[n] = true;
	        queue.offer(n);

	        while (!queue.isEmpty()) {
	            int node = queue.poll(); // 맨 앞 노드 빼주

	            for (int next : graph.get(node)) {
	                if (!visited[next]) {
	                    visited[next] = true;
	                    queue.offer(next); //노드 추
	                   
	                }
	            }
	        }
	    }

}
