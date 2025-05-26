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
        /**
         * 1부터 N까지 모든 노드를 순회해 사이클이 발생하는 노드를 확인하고, 사이클 발생 시 isCycle 배열에 사이클이라는 표시를 남겨둔
         */
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
    /**
     * 1부터 N까지의 노드(모든 노드)에서 사이클이 아닌 노드일 경우 bfs 탐색을 통해 사이클 노드까지의 거리를 구함 
     * 큐에 현재 노드와 count를 넣고 bfs 탐색 중 사이클 경로에 포함된 노드(isCycle 값이 true인 노드)인 경우 현재 count 값을 반환
     */
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
    /**
     * 사이클 여부를 확인하는 checkCycle 메서드의 동작 원리 
     *
     * 1. 현재 노드를 사이클 후보로 간주하고 isCycle[current]를 true로 설정
     *
     * 2. 현재 노드와 연결된 노드 중, 아직 사이클 여부가 확인되지 않은 노드에 대해서만 DFS 탐색을 진행
     *
     * 3. 만약 연결된 노드가 이미 방문된 노드인데,
     *    - 그 노드가 직전 노드가 아니고,
     *    - 시작 노드와 같은 경우,
     *    → 해당 경로는 처음 방문한 노드를 다시 만난 것이므로 사이클로 판단
     */

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