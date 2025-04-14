package Baekjoon.Sliver.baekjoon_1463;

import java.io.*;

public class baekjoon_1463_Wrong {

	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int X = Integer.parseInt(br.readLine());
			int count = 0;
			int dp [] = new int[X + 1];
			while(X > 1) {
				if(X >= 3) {
					X = X/3;
					count++;
				}
				if(X >= 2) {
					X = X/3;
					count++;
				}
				X--;
				count++;
				
			}
			System.out.println(count);

		}

	}