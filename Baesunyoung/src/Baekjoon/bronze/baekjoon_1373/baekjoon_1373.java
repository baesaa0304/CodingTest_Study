package Baekjoon.bronze.baekjoon_1373;

import java.io.*;
/**
* 작성한코드
 */

public class baekjoon_1373 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String two = br.readLine();
		Long ten = Long.parseLong(two , 2); // 2진수를 10진수로 변환 
		StringBuilder sb = new StringBuilder();
		while (ten > 0) {
            sb.append(ten % 8); // 나머지를 저장
            ten /= 8;           // 8로 나누기
        }
       
        System.out.println(sb.reverse().toString()); //413을 -> 314
	}

}
