package Baekjoon.Gold.baekjoon_13023;

import java.io.*;
import java.util.*;

public class baekjoon_13023_Worng {
	static int[][] graph;
    static boolean[] visited;
    static boolean found = false;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계 수

        graph = new int[N][N];
        visited = new boolean[N];

        // 친구 관계 입력 받기 (양방향)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] =  1;
        }

        // 모든 사람에서 DFS 시작
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (found) {
                break;
            }
        }
        // 친구 관계갸 유효하면 1 아니면 0
        if (found) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(int current, int depth) {
        if (depth == 5) {
            found = true;
            return;
        }

        visited[current] = true;

        for (int i = 0; i < N; i++) {
            if (graph[current][i] == 1 && !visited[i]) {
                dfs(i, depth + 1);
            }
        }

        visited[current] = false; // 백트래킹
    }

}
