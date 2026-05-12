package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3273 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 초기화 부분
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken().trim());
		}
		int x = Integer.parseInt(br.readLine());
		int answerCnt = 0;
		
		// 오름차순 정렬
		Arrays.sort(arr);
		
		// 양쪽 끝에 포인터 두기
		int left = 0;
		int right = n-1;
		
		// 두 포인터가 만나기 전까지 반복
		while (left < right) {
			int curSum = arr[left]+arr[right];
			
			if (curSum > x) {
				// 두 값의 합이 x보다 크면
				right--;
			} else if (curSum < x) {
				// 두 값의 합이 x보다 작으면
				left++;
			} else {
				// 두 값의 합이 x이면
				answerCnt++;
				right--;
				left++;
			}				
		}
		System.out.println(answerCnt);
	}
}
