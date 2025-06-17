package Baekjoon.Gold.No2146_MakeBridge;

import java.io.*;
import java.util.*;

public class No2146_MakeBridgeWrong {
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 섬마다 번호 부여
		int type = 2;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] != 0) {
					dfs(j, j, type++);
				}
			}
		}
		
		// 각 섬마다 다리 건설
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] > 1) {
					bfs(i, j, map[i][j]);
				}
			}
		}
        System.out.println(min);
	}

	/**
	 * 다리 건설, 서로 다른 섬 만날 때 최솟값 갱신.
	 * @param x
	 * @param y
	 * @param type
	 */
	private static void bfs(int x, int y, int type) {
		Queue<Integer[]> que = new LinkedList<>();
		visited = new boolean[n][n];
		visited[x][y] = true;
		que.offer(new Integer[] {x, y, 0});
		
		while(!que.isEmpty()) {
			Integer temp[] = que.poll();
			int nowX = temp[0];
			int nowY = temp[1];
			int count = temp[2]; // 거리 계산.
			
			// 바다 아니고 번호 다르면 최솟갑 갱신.
			// 시작점 제외하고 다리 개수 세야함.
			if(map[nowX][nowY] != 0 && map[nowX][nowY] != type) {
				min = Math.min(count - 1, min);
			}
			if(count > min) {
				return;
			}
			
			// 섬의 테두리만 탐색.
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) continue;
				
				// 번호 같으면 continue
				if(map[nx][ny] == type) continue;
				if(visited[nx][ny]) continue;
				que.offer(new Integer[] {nx, ny, count + 1});
				visited[nx][ny] = true;
			}
		}
		
	}

	/**
	 * 섬마다 번호 부여 함수
	 * @param y: 방향
	 * @param x: 방향
	 * @param type: 각 섬의 번호
	 */
	private static void dfs(int x, int y, int type) {
		visited[x][y] = true;
		map[x][y] = type;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) continue;
			if(visited[nx][ny] || map[nx][ny] != 1) continue;
			dfs(nx, ny, type);
		}

	}

}
