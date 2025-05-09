package Baekjoon.Sliver.baekjoon_14889;
import java.io.*;
import java.util.*;

public class baekjoon_14899_bit {
	static int N;
    static int[][] S;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalMask = (1 << N); // 2^N

        for (int mask = 0; mask < totalMask; mask++) {
            if (Integer.bitCount(mask) != N / 2) continue;

            List<Integer> start = new ArrayList<>();
            List<Integer> link = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    start.add(i);
                } else {
                    link.add(i);
                }
            }

            int diff = Math.abs(calcAbility(start) - calcAbility(link));
            minDiff = Math.min(minDiff, diff);
        }

        System.out.println(minDiff);
    }

    static int calcAbility(List<Integer> team) {
        int sum = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = 0; j < team.size(); j++) {
                if (i != j) {
                    sum += S[team.get(i)][team.get(j)];
                }
            }
        }
        return sum;
    }

}
