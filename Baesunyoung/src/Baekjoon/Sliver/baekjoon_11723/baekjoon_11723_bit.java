package Baekjoon.Sliver.baekjoon_11723;

import java.io.*;

public class baekjoon_11723_bit {
	 public static void main(String[] args) throws IOException {
	        // 빠른 입력을 위해 BufferedReader 사용
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        // 빠른 출력을 위해 StringBuilder 사용
	        StringBuilder sb = new StringBuilder();

	        int M = Integer.parseInt(br.readLine());  // 명령 수
	        int bitSet = 0;  // 집합 상태를 비트마스크로 표현 (int = 32비트)

	        for (int i = 0; i < M; i++) {
	            String[] command = br.readLine().split(" ");
	            String op = command[0];
	            int x = 0;
	            if (command.length == 2) {
	                x = Integer.parseInt(command[1]);
	            }

	            switch (op) {
	                case "add":
	                    bitSet |= (1 << (x - 1));
	                    break;
	                case "remove":
	                    bitSet &= ~(1 << (x - 1));
	                    break;
	                case "check":
	                    sb.append((bitSet & (1 << (x - 1))) != 0 ? "1\n" : "0\n");
	                    break;
	                case "toggle":
	                    bitSet ^= (1 << (x - 1));
	                    break;
	                case "all":
	                    bitSet = (1 << 20) - 1;  // 1~20 비트 모두 1로
	                    break;
	                case "empty":
	                    bitSet = 0;
	                    break;
	            }
	        }

	        // 한 번에 출력
	        System.out.print(sb);
	    }

}
