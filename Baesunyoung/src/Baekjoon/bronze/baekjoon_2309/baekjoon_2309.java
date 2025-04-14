package Baekjoon.bronze.baekjoon_2309;

import java.io.*;
import java.util.*;

public class baekjoon_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        int[] result = solution(arr, sum);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int arr[], int sum) {
        int a = 0, b = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    a = i;
                    b = j;
                    return constructAnswer(arr, a, b); // 
                }
            }
        }
        return new int[0]; // 실패할 경우 (없을 리 없음)
    }

    public static int[] constructAnswer(int arr[], int a, int b) {
        int[] answer = new int[7];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i != a && i != b) {
                answer[index++] = arr[i]; 
            }
        }
        return answer;
    }
}