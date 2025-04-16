package Baekjoon.Sliver;

import java.io.*;
import java.util.*;


public class baekjoon_6603 {
	static StringBuilder sb = new StringBuilder();
    static int[] lotto;
    static int K;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) break;
            lotto = new int[K];
            for(int i = 0; i < K; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }
            generateCombinations(new ArrayList<>(), 0);
            System.out.println(); // 각 테스트 케이스 사이에 빈 줄 출력
        }
    }

    private static void generateCombinations(List<Integer> combination, int start) {
        if(combination.size() == 6) {
            for(int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < K; i++) {
            combination.add(lotto[i]);
            generateCombinations(combination, i + 1);
            combination.remove(combination.size() - 1); // 마지막 요소 제거
        }
    }
}
