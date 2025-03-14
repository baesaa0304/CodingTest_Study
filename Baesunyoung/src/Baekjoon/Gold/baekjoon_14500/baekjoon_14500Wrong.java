package Baekjoon.Gold.baekjoon_14500;


import java.io.*;
import java.util.*;

public class baekjoon_14500Wrong {

    // 테트로미노 모형 정의
    private static final int[][][] shapes = {
        // I 모양 (가로, 세로)
        {{0,0}, {0,1}, {0,2}, {0,3}},
        {{0,0}, {1,0}, {2,0}, {3,0}},
        
        // O 모양
        {{0,0}, {0,1}, {1,0}, {1,1}},
        
        // T 모양
        {{0,0}, {0,1}, {0,2}, {1,1}},
        
        // L 모양 (4가지 회전)
        {{0,0}, {1,0}, {2,0}, {2,1}},
        {{0,1}, {1,1}, {2,1}, {2,0}},
        {{0,0}, {0,1}, {0,2}, {1,0}},
        {{0,0}, {1,0}, {1,1}, {1,2}},
        
        // S 모양 (2가지 회전)
        {{0,0}, {0,1}, {1,1}, {1,2}},
        {{0,1}, {1,0}, {1,1}, {2,0}}
    };

    public static void main(String[] args) throws IOException {
        // BufferedReader를 이용해 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        // 보드 크기 입력
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]); // N 세로 
        int M = Integer.parseInt(size[1]); // M 가로 

        // 보드 입력
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
        	 StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최댓값을 구하는 메서드 호출
         
        System.out.println(solution(N, M, board));
    }

    public static int solution(int N, int M, int[][] board) {
        int answer = 0;

        // 각 테트로미노 모양에 대해 계산
        for (int[][] shape : shapes) {
            // 보드의 모든 위치에 대해 테트로미노를 배치
            for (int i = 0; i <= N - 1; i++) {
                for (int j = 0; j <= M - 1; j++) {
                    // 테트로미노가 현재 위치에서 배치 가능한지 확인
                    int sum = 0;
                    boolean isValid = true;
                    
                    for (int k = 0; k < shape.length; k++) {
                        int x = i + shape[k][0];
                        int y = j + shape[k][1];
                        
                        // 배치가 보드를 벗어나면 안됨
                        if (x < 0 || x >= N || y < 0 || y >= M) {
                            isValid = false;
                            break;
                        }
                        
                        sum += board[x][y]; // 해당 위치 값 합산
                    }
                    
                    // 배치가 유효하면 최대값 갱신
                    if (isValid) {
                    	answer = Math.max(answer, sum);
                    }
                }
            }
        }

        return answer;
    }
}