package Baekjoon.bronze.baekjoon_1373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
* 작성한코드
 */
public class baekjoon_1373_correct {

	  public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        // 2진수 입력 받기
	        String binary = br.readLine();

	        // 2진수를 10진수로 변환 (BigInteger 사용)
	        BigInteger decimal = new BigInteger(binary, 2);

	        // 10진수를 8진수 문자열로 변환
	        String octal = decimal.toString(8);

	        // 결과 출력
	        System.out.println(octal);
	    }

}
