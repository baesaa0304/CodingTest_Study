package Baekjoon.Sliver.baekjoon_13414;


import java.io.*;
import java.util.*;
public class baekjoon_13414_wrong {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		 for (int i = 0; i < L; i++) {
			 st = new StringTokenizer(br.readLine());
	            String studentId = st.nextToken();
	            map.put(studentId, i); 
	        }
		 
	}

}
