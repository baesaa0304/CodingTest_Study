package Baekjoon.Gold.baekjoon_16947;

import java.io.*;
import java.util.*;

public class baekjoon_16947 {
	static ArrayList<Integer>[] subway;
    static int N;
    static boolean[] isCycle;

    static class Node {
        int vertex, count;

        public Node(int vertex, int count) {
            this.vertex = vertex;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        subway = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) subway[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            subway[a].add(b);
            subway[b].add(a);
        }

        isCycle = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (checkCycle(i, i, i)) break;
            isCycle = new boolean[N + 1];
        }

        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!isCycle[i]) result[i] = bfs(i);
        }

        for (int i = 1; i <= N; i++) System.out.print(result[i] + " ");
    }

    private static int bfs(int node) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(new Node(node, 0));
        visited[node] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (isCycle[now.vertex]) return now.count;

            for (int next : subway[now.vertex]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Node(next, now.count + 1));
                }
            }
        }
        return 0;
    }

    private static boolean checkCycle(int prev, int cur, int start) {
        isCycle[cur] = true;
        for (int i = 0; i < subway[cur].size(); i++) {
            int next = subway[cur].get(i);

            if (!isCycle[next]) {
                if (checkCycle(cur, next, start)) return true;
            } else if (prev != next && next == start) return true;
        }
        isCycle[cur] = false;

        return false;
    }
}