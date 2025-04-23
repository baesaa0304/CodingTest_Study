package Baekjoon.Gold.baekjoon_1759;

import java.io.*;
import java.util.*;

public class baekjoon_1759 {
    static int L, C;
    static char[] input;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // L: 암호의 길이, C: 문자 개수
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input); // 사전 순 정렬
        solution(0, 0);     // 조합 시작
        System.out.print(sb);
    }

    // start: 조합 시작 인덱스, depth: 현재까지 선택한 문자 수
    public static void solution(int start, int depth) {
        if (depth == L) {
            StringBuilder password = new StringBuilder();
            int vowel = 0;       // 모음 개수
            int consonant = 0;   // 자음 개수

            for (int i = 0; i < C; i++) {
                if (visited[i]) {
                    password.append(input[i]);
                    if (isVowel(input[i])) vowel++;
                    else consonant++;
                }
            }

            // 모음 ≥1, 자음 ≥2 조건을 만족하면 결과에 추가
            if (vowel >= 1 && consonant >= 2) {
                sb.append(password).append("\n");
            }
            return;
        }

        // 조합 생성 (중복 없이 오름차순으로)
        for (int i = start; i < C; i++) {
            visited[i] = true;
            solution(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    // 모음 여부 확인 함수
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}