package Baekjoon.Sliver.baekjoon_17103;

import java.io.*;

public class baekjoon_17103 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 최대 범위
        int max = 1000000;

        // 소수 판별 배열 (true: 소수, false: 소수 아님)
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체로 소수 구하기
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;

            // 골드바흐 파티션 구하기
            for (int i = 2; i <= n / 2; i++) {
                if (isPrime[i] && isPrime[n - i]) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        // 결과 출력
        System.out.print(sb);
    }
}