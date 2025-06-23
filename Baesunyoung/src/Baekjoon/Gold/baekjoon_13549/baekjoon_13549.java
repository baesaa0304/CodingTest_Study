package Baekjoon.Gold.baekjoon_13549;
	
import java.io.*;
import java.util.*;

public class baekjoon_13549 {
	static int subin , brother;
	static int[] arr = new int[100001];
	static boolean[] visit = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());
        
        bfs(subin);
        System.out.println(arr[brother]);
	}
	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(start);
		visit[start] = true;
		while(!que.isEmpty()) {
			int location = que.poll();
			if(location == brother) {
				return;
			}
			int back = location - 1;
			int front = location + 1;
			int tele = location * 2;
			if (tele >=0 && tele <= 100000 && !visit[tele]) {
				que.offer(tele);
				visit[tele] = true;
				arr[tele] = arr[location];
			}
			int[] nextLocations = {back, front};
			for (int next : nextLocations) {
                if (next >= 0 && next <= 100000) {
                    if (!visit[next]) {
                        que.offer(next);
                        visit[next] = true;
                        arr[next] = arr[location] + 1;
                    } 
                }
            }
		}
	}

}
