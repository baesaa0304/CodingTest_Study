
package Baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No1373_BinaryAndOctal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		
		//2진수 -> 8진수로 변환할 떄 3개씩 끊어야 함.
		// 1. input의 입력값이 3으로 나누어 떨어지는지 확인.
		// 	2. 아닐 경우 맨 앞에 0 추가 (단, 길이 % 3 == 0이어야 하므로)
		//		길이 % 3의 나머지 값만큼 0추가.(이때 0은 문자열)
		if(input.length() % 3 != 0) {
			for(int i = 0; i<input.length()%3; i++) {
				input = "0" + input;
			}
		}
		StringBuilder sb = new StringBuilder();
		// 2진수 -> 8진수 변경 및 bw에 추가
		// 변환 시 3개로 끊어야 하므로 [0] + 3번째로 끊기
		// [0] * 2^2 + [1] * 2^1 + [2] * 1 
		for(int i = 0; i < input.length(); i += 3) {
			sb.append(Character.getNumericValue(input.charAt(i + 2)) +
					Character.getNumericValue(input.charAt(i + 1)) * 2 + 
					Character.getNumericValue(input.charAt(i)) * 4);
		}
		// 완성된 8진수를 bw에 넣음.
		bw.append(sb.toString());
		bw.flush();
		bw.close();

	}

}
